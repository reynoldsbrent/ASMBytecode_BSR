/**Compare two numbers (I, S, L) to determine which is bigger and print it
 * Author: Brent Reynolds
*/

import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

public class gen4 {
    private static final Label SecondIntGreaterOrEqual = new Label();
    private static final Label SecondShortGreaterOrEqual = new Label();

    public static void main(String[] args) {

        
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "program4", null, "java/lang/Object", null);

        // constructor
        {
            MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(Opcodes.ALOAD, 0); 
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        // main method
        {
            MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();

            // Declare and initialize variables
            mv.visitLdcInsn(1); // First int loaded
            mv.visitVarInsn(Opcodes.ISTORE, 1);
            mv.visitLdcInsn(2); // Second int
            mv.visitVarInsn(Opcodes.ISTORE, 2);
            mv.visitIntInsn(Opcodes.SIPUSH, 1); // First short
            mv.visitVarInsn(Opcodes.ISTORE, 3);
            mv.visitIntInsn(Opcodes.SIPUSH, 2); // Second short
            mv.visitVarInsn(Opcodes.ISTORE, 4);
            mv.visitLdcInsn(10500L); // First long
            mv.visitVarInsn(Opcodes.LSTORE, 5);
            mv.visitLdcInsn(5500L); // Second long
            mv.visitVarInsn(Opcodes.LSTORE, 6);

            // Int comparison
            mv.visitVarInsn(Opcodes.ILOAD, 1); // Load first int
            mv.visitVarInsn(Opcodes.ILOAD, 2); // Load second int
            Label intComparisonEnd = new Label();
            mv.visitJumpInsn(Opcodes.IF_ICMPLE, SecondIntGreaterOrEqual); // Jump if second int is greater or equal to first int
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("The first int is >");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitJumpInsn(Opcodes.GOTO, intComparisonEnd);
            mv.visitLabel(SecondIntGreaterOrEqual);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("The second int is >=");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitLabel(intComparisonEnd);

            // Short comparison
            mv.visitVarInsn(Opcodes.ILOAD, 3); // Load first short
            mv.visitVarInsn(Opcodes.ILOAD, 4); // Load second short
            Label EndShortComparison = new Label();
            mv.visitJumpInsn(Opcodes.IF_ICMPLE, SecondShortGreaterOrEqual); // Jump if second short is greater or equal to the first short
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("The first short is >");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitJumpInsn(Opcodes.GOTO, EndShortComparison);
            mv.visitLabel(SecondShortGreaterOrEqual);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("The second short is >=");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitLabel(EndShortComparison);

            // Long comparison
            mv.visitVarInsn(Opcodes.LLOAD, 5); // Load first long
            mv.visitVarInsn(Opcodes.LLOAD, 6); // Load second long
            Label EndLongComparison = new Label();
            mv.visitInsn(Opcodes.LCMP); // Compare the two longs longs
            Label SecondLongGreaterOrEqual = new Label();
            mv.visitJumpInsn(Opcodes.IFLE, SecondLongGreaterOrEqual); // Jump if first long is less than or equal to the second long
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("The first long is >");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitJumpInsn(Opcodes.GOTO, EndLongComparison);
            mv.visitLabel(SecondLongGreaterOrEqual);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("The second long is >=");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

            mv.visitLabel(EndLongComparison);


            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b, "program4.class");

        System.out.println("Done!");
    }

}


