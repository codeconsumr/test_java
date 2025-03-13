package exercises;

import ast.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ex1 {

    public static void main(String[] args) throws IOException {
        List<VarDecl> decls = new ArrayList<>();
        decls.add(new VarDecl(new TypeInt(), "size"));

        List<Stm> stms = new ArrayList<>();
        Exp ve = new ExpTimes(new ExpInt(3), new ExpInt(2));
        stms.add(new StmAssign("size", ve));
        Exp e = new ExpPlus(new ExpInt(1), new ExpVar("size"));
        stms.add(new StmPrintln(e));

        Program program = new Program(decls, stms);

        // pretty-print the program
        System.out.println(program);

        // uncomment these two lines to test your compile methods
//        program.compile();
//        AST.write(Paths.get("Ex1.ssma"));
    }
}
