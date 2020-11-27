import java.util.function.LongConsumer;

public class LongConsumerImpl{
    private static class LongConsume implements LongConsumer{
        @Override
        public void accept(final long longValue){
            System.out.println("Long " + longValue);
        }
    }

    private static final LongConsumer longConsumerAnon = new LongConsumer(){
                                                             @Override
							     public void accept(final long longValue){
							         System.out.println("Long Value " + longValue);
							     }
							 };
    private static final LongConsumer longConsumerLambda = (final long longValue) -> System.out.println("Long Value" + longValue);
    private static final LongConsumer longConsumerLambda2    = (longValue) -> System.out.println("Long Value " + longValue);
    private static final LongConsumer longConsumerLambda3    = System.out::println;

    public static void main(final String ... args){
        final LongConsume lngClass = new LongConsume();

	lngClass.accept(100L);
	longConsumerAnon.accept(100L);
	longConsumerLambda.accept(100L);
	longConsumerLambda2.accept(100L);
	longConsumerLambda3.accept(100L);
    }
}
