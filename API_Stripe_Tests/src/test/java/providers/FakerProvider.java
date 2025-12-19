package providers;

import net.datafaker.Faker;

public class FakerProvider {
    private static final ThreadLocal<Faker> FAKER =
            ThreadLocal.withInitial(Faker::new);

    public static Faker faker() {
        return FAKER.get();
    }
}
