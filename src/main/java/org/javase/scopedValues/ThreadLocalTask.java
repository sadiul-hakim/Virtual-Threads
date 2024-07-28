package org.javase.scopedValues;

public class ThreadLocalTask{
    public static final InheritableThreadLocal<User> user = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("User 1. => "+user.get());

        user.set(new User("main"));
        System.out.println("User 2. => "+user.get());

        Thread.ofVirtual().start(() -> {
            Thread.currentThread().setName("hakim-thread");
            System.out.println("User 3. => "+user.get());
            user.get().setName("Hakim");
            System.out.println("User 4. => "+user.get());
        }).join();
        System.out.println("User 5. => "+user.get());
    }
}
