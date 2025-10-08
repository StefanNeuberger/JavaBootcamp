import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainTest {

    private static int testsRun = 0;
    private static int testsFailed = 0;

    private static void assertTrue(String name, boolean condition) {
        testsRun++;
        if (!condition) {
            testsFailed++;
            System.out.println("[FAIL] " + name);
        } else {
            System.out.println("[PASS] " + name);
        }
    }

    private static class IOResult<T> {
        final T result;
        final String stdout;
        IOResult(T result, String stdout) { this.result = result; this.stdout = stdout; }
    }

    private static <T> IOResult<T> runWithIO(String input, IOCallable<T> callable) {
        // Backup streams
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;
        java.io.InputStream originalIn = System.in;

        try {
            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream captureOut = new PrintStream(outContent, true, StandardCharsets.UTF_8);

            System.setIn(in);
            System.setOut(captureOut);
            System.setErr(captureOut);

            try (Scanner sc = new Scanner(System.in)) {
                T result = callable.run(sc);
                captureOut.flush();
                String stdout = outContent.toString(StandardCharsets.UTF_8);
                return new IOResult<>(result, stdout);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // Restore streams
            System.setOut(originalOut);
            System.setErr(originalErr);
            System.setIn(originalIn);
        }
    }

    @FunctionalInterface
    private interface IOCallable<T> {
        T run(Scanner sc);
    }

    private static void testPromptString() {
        IOResult<String> r = runWithIO("\n   \nJohn Doe\n", sc -> Main.promptString(sc, "Name: "));
        assertTrue("promptString returns trimmed non-empty value", r.result.equals("John Doe"));
        assertTrue("promptString prints fallback on empty lines", r.stdout.contains(Main.fallbackMessage));
    }

    private static void testPromptChar() {
        // empty -> digit -> multi-char -> valid letter 'Z'
        IOResult<Character> r = runWithIO("\n9\nab\nZ\n", sc -> Main.promptChar(sc, "Letter: "));
        assertTrue("promptChar returns the first valid letter entered", r.result == 'Z');
        assertTrue("promptChar rejects non-letters", r.stdout.contains("No digits or symbols"));
        assertTrue("promptChar rejects multiple characters", r.stdout.contains("exactly one letter"));
        assertTrue("promptChar prints fallback on empty input", r.stdout.contains(Main.fallbackMessage));
    }

    private static void testPromptInt() {
        IOResult<Integer> r = runWithIO("foo\n42\n", sc -> Main.promptInt(sc, "Int: "));
        assertTrue("promptInt returns integer after invalid token", r.result == 42);
        assertTrue("promptInt shows error message on invalid", r.stdout.contains("That's not a valid integer"));
    }

    private static void testPromptNonNegativeInt() {
        IOResult<Integer> r = runWithIO("-5\n0\n", sc -> Main.promptNonNegativeInt(sc, "Age: "));
        assertTrue("promptNonNegativeInt rejects negatives and accepts 0", r.result == 0);
        assertTrue("promptNonNegativeInt prints guidance", r.stdout.contains("non-negative"));
    }

    private static void testPromptDouble() {
        IOResult<Double> r = runWithIO("abc\n3.14\n", sc -> Main.promptDouble(sc, "Double: "));
        assertTrue("promptDouble returns value after invalid token", Math.abs(r.result - 3.14) < 1e-9);
        assertTrue("promptDouble shows error message on invalid", r.stdout.contains("That's not a valid double"));
    }

    private static void testIsVowel() {
        assertTrue("isVowel('a') is true", Main.isVowel('a'));
        assertTrue("isVowel('E') is true", Main.isVowel('E'));
        assertTrue("isVowel('u') is true", Main.isVowel('u'));
        assertTrue("isVowel('b') is false", !Main.isVowel('b'));
        assertTrue("isVowel('Y') is false", !Main.isVowel('Y'));
    }

    public static void main(String[] args) {
        System.out.println("Running MainTest...");
        testPromptString();
        testPromptChar();
        testPromptInt();
        testPromptNonNegativeInt();
        testPromptDouble();
        testIsVowel();
        System.out.println();
        System.out.printf("Tests run: %d, Failures: %d%n", testsRun, testsFailed);
        if (testsFailed > 0) {
            System.exit(1);
        }
    }
}
