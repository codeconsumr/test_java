package exercises;

import ast.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ex4 {

    public static void main(String[] args) throws IOException {
        TypeInt intType = new TypeInt();

        List<VarDecl> decls = new ArrayList<>();
        decls.add(new VarDecl(intType, "x"));

        List<Stm> blockStms = new ArrayList<>();
        blockStms.add(new StmAssign("x", new ExpMinus(new ExpVar("x"), new ExpInt(7))));
        blockStms.add(
                new StmIf(
                        new ExpLessThan(new ExpVar("x"), new ExpInt(13)),
                        new StmPrintln(new ExpVar("x")),
                        new StmPrintln(new ExpInt(88))
                )
        );

        List<Stm> stms = new ArrayList<>();
        stms.add(new StmAssign("x", new ExpInt(20)));
        stms.add(new StmIf(
                new ExpEqual(new ExpVar("x"), new ExpInt(20)),
                new StmBlock(blockStms),
                new StmBlock(new ArrayList<>())
        ));

        Program program = new Program(decls, stms);

        // pretty-print the program
        System.out.println(program);

        // uncomment these two lines to test your compile methods
//        program.compile();
//        AST.write(Paths.get("Ex4.ssma"));
    }
}
