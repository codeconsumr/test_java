package exercises;

import ast.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ex2 {

//    private static Exp var(String x) {
//        return new ExpVar(x);
//    }

    public static void main(String[] args) throws IOException {
        TypeInt intType = new TypeInt();

        List<VarDecl> decls = new ArrayList<>();
        decls.add(new VarDecl(intType, "y"));

        List<Stm> stms = new ArrayList<>();
        stms.add(new StmAssign(
                    "y",
                    new ExpMinus(new ExpVar("y"), new ExpInt(1))
                )
        );
        stms.add(new StmPrintln(
                new ExpTimes(
                        new ExpInt(3),
                        new ExpPlus(new ExpVar("y"), new ExpInt(7)))
                )
        );

        Program program = new Program(decls, stms);

        // pretty-print the program
        System.out.println(program);

        // uncomment these two lines to test your compile methods
//        program.compile();
//        AST.write(Paths.get("Ex2.ssma"));
    }
}
