import Test.Aggregator.{amountBracket, hour}

import java.util.Date
import scala.Ordering
import scala.collection.mutable
import scala.io.{Source, StdIn}

object Test extends App {

  import PaymentMethod.PaymentMethod

  import scala.collection.mutable.ListBuffer

  object PaymentMethod extends Enumeration {
    type PaymentMethod = Value
    val PAY_NOW, PAY_LATER, SLICE_IT = Value
  }

  class CheckoutEvent(val checkoutDateTime: String, val amount: Long, val paymentMethod: PaymentMethod, val merchantId: String) {
    override def toString: String =
      "Event(" + checkoutDateTime + "," + amount + "," + paymentMethod + "," + merchantId + ")"
  }

  case class Aggregate(val datapoint: String, val events: Long) {
    override def toString: String =
      "Aggregate(" + datapoint + "," + events + ")"

    override def equals(obj: scala.Any): Boolean =
      obj match {
        case other: Aggregate => datapoint.equals(other.datapoint) && events.equals(other.events)
        case _: scala.Any => false
      }
  }

  object Aggregator {

    private def day(event: CheckoutEvent) = "^(.+)T.+$".r.replaceAllIn(event.checkoutDateTime, "$1")

    private def hour(event: CheckoutEvent) = "^(.+)T(\\d+):.+$".r.replaceAllIn(event.checkoutDateTime, "$1:$2")

    private def amountBracket(event: CheckoutEvent) =
      if (event.amount < 1000) {
        "<10"
      } else if (event.amount < 5000) {
        "10-50"
      } else if (event.amount < 10000) {
        "50-100"
      } else if (event.amount < 50000) {
        "100-500"
      } else {
        ">500"
      }

       def aggregate(checkoutEvents: List[CheckoutEvent]): List[Aggregate] = {
      checkoutEvents.foldLeft(List.empty[Aggregate])((acc, event) => {
        val purchasePerHourByAmountBracketFilter = (aggregate: Aggregate) => (aggregate.datapoint == hour(event) + "|" + amountBracket(event))

        val purchasesPerHourByAmountBracketAndPaymentMethodFilter = (aggregate: Aggregate) =>
          aggregate.datapoint == (hour(event) + "|" + amountBracket(event) + "|" + event.paymentMethod)

        val purchasesByAmountBracketAndPaymentMethodFilter = (aggregate: Aggregate) =>
          aggregate.datapoint == (amountBracket(event) + "|" + event.paymentMethod)

        val purchasesPerDayByMerchantFilter = (aggregate: Aggregate) =>
          aggregate.datapoint == (day(event) + "|" + event.merchantId)

        val increaseEventCount = (aggregate: Aggregate) => aggregate.copy(events = aggregate.events + 1)

        for {
          purchasePerHourByAmountBracket  <- acc.find(purchasePerHourByAmountBracketFilter(_)).map(increaseEventCount)
          purchasesPerHourByAmountBracketAndPaymentMethod <- acc.find(purchasesPerHourByAmountBracketAndPaymentMethodFilter(_)).map(increaseEventCount)
          purchasesByAmountBracketAndPaymentMethod <- acc.find(purchasesByAmountBracketAndPaymentMethodFilter(_)).map(increaseEventCount)
          purchasesPerDayByMerchant <- acc.find(purchasesPerDayByMerchantFilter(_)).map(increaseEventCount)
          purchaseByMerchantAndPaymentMethod <- acc.find(purchasesPerDayByMerchantFilter(_)).map(increaseEventCount)
        } yield  {
          List(purchasePerHourByAmountBracket, purchasesPerHourByAmountBracketAndPaymentMethod,
          purchasesByAmountBracketAndPaymentMethod, purchasesPerDayByMerchant, purchaseByMerchantAndPaymentMethod)
        }
      }.getOrElse(List.empty))

    }
  }

}