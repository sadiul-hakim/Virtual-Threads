package org.javase.scopedValues;

public class ScopedValuePlay {
    private static final ScopedValue<User> user = ScopedValue.newInstance();

    public static void main(String[] args) throws Exception {
        print("user is bound => " + user.isBound());

        User bob = new User("bob");
        ScopedValue.runWhere(user, bob, ScopedValuePlay::handleUser);
        print("user is bound =>" + user.isBound());
    }

    private static void handleUser() {
        print("user -> " + user.get());

        ScopedValue.runWhere(user, new User("None"),ScopedValuePlay::NoneUser );

        print("user -> " + user.get());
    }

    private static void NoneUser() {
        callAgain();
    }

    private static void callAgain(){
        print("None ->" + user.get());
    }

    public static void print(String msg) {
        System.out.printf("[%s] %s\n", Thread.currentThread(), msg);
    }

    static class ScopedUserHandler {
        public boolean handle() {
            final boolean bound = ScopedValuePlay.user.isBound();
            try {
                Thread.ofVirtual().start(() -> {
                    print("handle - user is bound -> " + bound);

                    if (bound) {
                        User user = ScopedValuePlay.user.orElse(new User("None"));
                        print("handle - user =>" + user);
                    }
                }).join();
            } catch (Exception ignore) {
            }

            return bound;
        }
    }
}
