package io.millesabords.zeppelin.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.zeppelin.interpreter.Interpreter;
import org.apache.zeppelin.interpreter.InterpreterContext;
import org.apache.zeppelin.interpreter.InterpreterResult;
import org.apache.zeppelin.interpreter.InterpreterResult.Code;
import org.apache.zeppelin.interpreter.InterpreterResult.Type;

public class DateTimeInterpreter extends Interpreter {

    public static void main(String[] args) {
        DateTimeInterpreter i = new DateTimeInterpreter(null);
        InterpreterResult r = i.interpret("clock", new InterpreterContext("noteId", "paragraphId", "paragraphTitle", "paragraphText", null,
                null, null, null, null, null, null));
        System.out.println(r.message());
    }

    private static final String CLOCK_SCRIPT_SRC =
            new Scanner(DateTimeInterpreter.class.getResourceAsStream("/clock.js"), "UTF-8").useDelimiter("\\A").next();


    static {
        Interpreter.register("datetime", "demo", DateTimeInterpreter.class.getName());
    }

    public DateTimeInterpreter(Properties property) {
        super(property);
    }

    @Override
    public InterpreterResult interpret(String commands, InterpreterContext ctx) {

        final StringBuilder result = new StringBuilder();
        Code resultCode = Code.SUCCESS;

        if ("clock".equalsIgnoreCase(commands)) {
            result.append("<script>").append(CLOCK_SCRIPT_SRC.replace("__PARAGRAPH_ID__", ctx.getParagraphId())).append("</script>");
            result.append("<strong id=\"clock-").append(ctx.getParagraphId()).append("\">").append("</strong>");
        } else {
            result.append("<div class=\"alert alert-danger\" role=\"alert\">Unknown command:").append(commands).append("</div>");
            resultCode = Code.ERROR;
        }

        return new InterpreterResult(resultCode, Type.HTML, result.toString());
    }

    @Override
    public List<String> completion(String arg0, int arg1) {
        return Arrays.asList("clock");
    }

    @Override
    public void open() {
    }

    @Override
    public void close() {
    }

    @Override
    public void cancel(InterpreterContext arg0) {
    }

    @Override
    public FormType getFormType() {
        return FormType.SIMPLE;
    }

    @Override
    public int getProgress(InterpreterContext arg0) {
        return 0;
    }
}
