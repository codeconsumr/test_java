package exercises;

import ast.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ex5 {

    public static void main(String[] args) throws IOException {
        TypeInt intType = new TypeInt();

        List<VarDecl> decls = new ArrayList<>();
        decls.add(new VarDecl(intType, "zz"));
        decls.add(new VarDecl(intType, "ab"));

        List<StmSwitch.Case> cases = new ArrayList<>();
        cases.add(new StmSwitch.Case(7, new StmPrintln(new ExpInt(99))));
        cases.add(new StmSwitch.Case(1, new StmPrintln(new ExpVar("zz"))));

        List<Stm> stms = new ArrayList<>();
        stms.add(new StmAssign("z", new ExpInt(55)));
        stms.add(new StmSwitch(
                new ExpPlus(new ExpVar("ab"), new ExpInt(1)),
                new StmPrintln(new ExpVar("ab")),
                cases
        ));

        Program program = new Program(decls, stms);

        // pretty-print the program
        System.out.println(program);

        // uncomment these two lines to test your compile methods
//        program.compile();
//        AST.write(Paths.get("Ex5.ssma"));
    }
}
