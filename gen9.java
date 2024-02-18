/** Get input (I), from the user, run a loop that adds that number to an accumulator,
and then print the result. 
Author: Brent Reynolds*/

import static utils.Utilities.writeFile;
import org.objectweb.asm.*;

public class gen9 {

    public static void main(String[] args) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "program9", null, "java/lang/Object", null);

       
        MethodVisitor constructor = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        constructor.visitCode();
        constructor.visitVarInsn(Opcodes.ALOAD, 0);
        constructor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        constructor.visitInsn(Opcodes.RETURN);
        constructor.visitMaxs(1, 1);
        constructor.visitEnd();

       
        MethodVisitor main = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        main.visitCode();

        // Scanner and Accumulator initialization
        main.visitTypeInsn(Opcodes.NEW, "java/util/Scanner");
        main.visitInsn(Opcodes.DUP);
        main.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");
        main.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false);
        main.visitVarInsn(Opcodes.ASTORE, 1); // Store Scanner

        main.visitInsn(Opcodes.ICONST_0); // Accumulator initialized to 0
        main.visitVarInsn(Opcodes.ISTORE, 2); // Store accumulator

        // Get user input
        main.visitVarInsn(Opcodes.ALOAD, 1); // Scanner loaded
        main.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false); // Call nextDouble method to get input
        main.visitVarInsn(Opcodes.ISTORE, 3); // Store input


        // Loop counter
        main.visitInsn(Opcodes.ICONST_0);
        main.visitVarInsn(Opcodes.ISTORE, 4);

        // While loop start
        Label start = new Label();
        main.visitLabel(start);

        // Load loop counter
        main.visitVarInsn(Opcodes.ILOAD, 4);

        // Load loop limit
        main.visitIntInsn(Opcodes.SIPUSH, 10);
        Label end = new Label();
        // Compare loop counter and loop limit
        main.visitJumpInsn(Opcodes.IF_ICMPGE, end); // Jump to the end label if loop counter is greater than or equal to 10



        // Input added to accumulator
        main.visitVarInsn(Opcodes.ILOAD, 2); // Load accumulator
        main.visitVarInsn(Opcodes.ILOAD, 3); // Load the number that the user input earlier
        main.visitInsn(Opcodes.IADD); // Add input to accumulator
        main.visitVarInsn(Opcodes.ISTORE, 2); // Store accumulator


        // Increment loop counter
        main.visitIincInsn(4, 1);

        // Jump to loop start
        main.visitJumpInsn(Opcodes.GOTO, start);

        // Loop end
        main.visitLabel(end);

        // Print sum value
        main.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        main.visitVarInsn(Opcodes.ILOAD, 2);
        main.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

        main.visitInsn(Opcodes.RETURN);

        main.visitMaxs(0, 0);
        main.visitEnd();

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b, "program9.class");

        System.out.println("Done!");
    }
}
