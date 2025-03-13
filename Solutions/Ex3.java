package exercises;

import ast.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ex3 {

    public static void main(String[] args) throws IOException {
        TypeInt intType = new TypeInt();

        List<VarDecl> decls = new ArrayList<>();
        decls.add(new VarDecl(intType, "x"));

        List<Stm> blockStms = new ArrayList<>();
        blockStms.add(new StmPrintln(new ExpVar("x")));
        blockStms.add(new StmAssign(
                    "x",
                    new ExpPlus(new ExpVar("x"), new ExpInt(1))
                )
        );

        List<Stm> stms = new ArrayList<>();
        stms.add(new StmAssign("x", new ExpMinus(new ExpInt(0), new ExpInt(5))));
        stms.add(new StmWhile(
                    new ExpVar("x"),
                    new StmBlock(blockStms)
                )
        );

        Program program = new Program(decls, stms);

        // pretty-print the program
        System.out.println(program);

        // uncomment these two lines to test your compile methods
//        program.compile();
//        AST.write(Paths.get("Ex3.ssma"));
    }
}
