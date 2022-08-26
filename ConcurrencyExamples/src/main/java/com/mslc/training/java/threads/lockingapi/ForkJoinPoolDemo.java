package com.mslc.training.java.threads.lockingapi;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class ForkJoinPoolDemo {

    public static void main(String[] args) {

        ForkJoinPool fjp = new ForkJoinPool();
        System.out.println(fjp.getParallelism());

        String value = "Haryana BJP's Sonali Phogat's Death: Murder Case Filed By Goa Police\n" +
                "Sonali Phogat's body is currently kept in the Goa Medical College and Hospital morgue\n" +
                "\n" +
                "\n" +
                "1\n" +
                "New Delhi: A murder case has been registered in the death of BJP leader Sonali Phogat, who was found dead in Goa. Her brother Rinku Dhaka had claimed she was murdered by two of her associates, who were travelling with her to Goa.\n" +
                "The brother said the family will allow the postmortem only after the Goa Police register an FIR or police case against the two persons.\n" +
                "\n" +
                "He also alleged that a short while before her death, Sonali Phogat had spoken to her mother, sister and brother-in-law. She sounded disturbed and complained against her two colleagues, he added.\n" +
                "\n" +
                "Sonali Phogat, who is from Hisar in Haryana had found fame on Tik Tok, was brought dead at the St Anthony Hospital in Anjuna area of North Goa district on Tuesday morning, a police official said earlier, adding that she died of a suspected heart attack. The police subsequently registered a case of unnatural death.\n" +
                "\n";

        MyUpperCaseTransformer task = new MyUpperCaseTransformer(value);
        fjp.execute(task);
        String transformedValue = task.join();
        System.out.println(transformedValue);


    }


}

class MyUpperCaseTransformer extends RecursiveTask<String> {


    private final int THRESHOLD = 4;
    private String value;

    MyUpperCaseTransformer(String value) {
        this.value = value;
    }

    @Override
    protected String compute() {
        System.out.println("in comp");

        if (value.length() > THRESHOLD) {

            MyUpperCaseTransformer t1 = new MyUpperCaseTransformer(value.substring(0, value.length() / 2));
            MyUpperCaseTransformer t2 = new MyUpperCaseTransformer(value.substring(value.length() / 2, value.length()));

            Collection<MyUpperCaseTransformer> tasksToSubmit = ForkJoinTask.invokeAll(Arrays.asList(t1, t2));

            String finalValue =
                    tasksToSubmit
                            .stream()
                            .map(x -> x.join())
                            .collect(Collectors.joining());
            return finalValue;

        } else {
            return this.value.toUpperCase();
        }


    }
}
