import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

public class gen4 {

    public static void main(String[] args) {

        // Create a ClassWriter
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        // Define class attributes
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "program4", null, "java/lang/Object", null);

        // Define a constructor
        {
            MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(Opcodes.ALOAD, 0); // load the first local variable: this
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        // Define a main method
        {
            MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();

            // Declare and initialize variables
            mv.visitLdcInsn(1); // Load var1
            mv.visitVarInsn(Opcodes.ISTORE, 1);
            mv.visitLdcInsn(2); // Load var3
            mv.visitVarInsn(Opcodes.ISTORE, 2);
            mv.visitIntInsn(Opcodes.SIPUSH, 1); // Load short value 1
            mv.visitVarInsn(Opcodes.ISTORE, 3);
            mv.visitIntInsn(Opcodes.SIPUSH, 2); // Load short value 2
            mv.visitVarInsn(Opcodes.ISTORE, 4);
            mv.visitLdcInsn(10000L); // Load long value 10000L
            mv.visitVarInsn(Opcodes.LSTORE, 5);
            mv.visitLdcInsn(5000L); // Load long value 5000L
            mv.visitVarInsn(Opcodes.LSTORE, 7);

            // Compare and print statements for integers
            mv.visitVarInsn(Opcodes.ILOAD, 1); // Load var1
            mv.visitVarInsn(Opcodes.ILOAD, 2); // Load var3
            Label intComparisonEnd = new Label();
            mv.visitJumpInsn(Opcodes.IF_ICMPLE, intSecondGreaterOrEqual); // Jump if var1 <= var3
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("The first int is larger");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitJumpInsn(Opcodes.GOTO, intComparisonEnd);
            mv.visitLabel(intSecondGreaterOrEqual);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("The second int is larger or equal");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitLabel(intComparisonEnd);

            // Compare and print statements for shorts
            mv.visitVarInsn(Opcodes.ILOAD, 3); // Load var5
            mv.visitVarInsn(Opcodes.ILOAD, 4); // Load var7
            Label shortComparisonEnd = new Label();
            mv.visitJumpInsn(Opcodes.IF_ICMPLE, shortSecondGreaterOrEqual); // Jump if var5 <= var7
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("The first short is larger");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitJumpInsn(Opcodes.GOTO, shortComparisonEnd);
            mv.visitLabel(shortSecondGreaterOrEqual);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("The second short is larger or equal");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitLabel(shortComparisonEnd);

            // Compare and print statements for longs
            mv.visitVarInsn(Opcodes.LLOAD, 5); // Load var9
            mv.visitVarInsn(Opcodes.LLOAD, 7); // Load var11
            Label longComparisonEnd = new Label();
            mv.visitInsn(Opcodes.LCMP); // Compare longs
            Label longSecondGreaterOrEqual = new Label();
            mv.visitJumpInsn(Opcodes.IFLE, longSecondGreaterOrEqual); // Jump if var9 <= var11
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("The first long is larger");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitJumpInsn(Opcodes.GOTO, longComparisonEnd);
            mv.visitLabel(longSecondGreaterOrEqual);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("The second long is larger or equal");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

            mv.visitLabel(longComparisonEnd);


            // Return
            mv.visitInsn(Opcodes.RETURN);

            // Define max stack and locals
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b, "program4.class");

        System.out.println("Done!");
    }

    private static final Label intSecondGreaterOrEqual = new Label();
    private static final Label shortSecondGreaterOrEqual = new Label();
    //private static final Label longSecondGreaterOrEqual = new Label();
}


