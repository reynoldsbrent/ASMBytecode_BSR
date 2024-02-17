/** Implement a While Loop */

import static utils.Utilities.writeFile;
import org.objectweb.asm.*;

public class gen7 {

    public static void main(String[] args) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "program7", null, "java/lang/Object", null);

        
        MethodVisitor constructor = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        constructor.visitCode();
        constructor.visitVarInsn(Opcodes.ALOAD, 0);
        constructor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        constructor.visitInsn(Opcodes.RETURN);
        constructor.visitMaxs(1, 1);
        constructor.visitEnd();

        
        MethodVisitor main = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        main.visitCode();

        // Declare and initialize loop counter
        main.visitInsn(Opcodes.ICONST_0);
        main.visitVarInsn(Opcodes.ISTORE, 1);

        // While loop start
        Label start = new Label();
        main.visitLabel(start);

        // This loads the loop counter 
        main.visitVarInsn(Opcodes.ILOAD, 1);

        // This loads the loop limit
        main.visitIntInsn(Opcodes.SIPUSH, 10);
        Label end = new Label();
        // Loop counter is compared to loop limit
        main.visitJumpInsn(Opcodes.IF_ICMPGE, end); // Jump to the end label if the loop counter is greater than or equal to 10

        // Print out loop counter
        main.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        main.visitVarInsn(Opcodes.ILOAD, 1);
        main.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

        // Increment the loop counter
        main.visitIincInsn(1, 1);

        // Jump back to loop start
        main.visitJumpInsn(Opcodes.GOTO, start);

        // End of loop
        main.visitLabel(end);

        
        main.visitInsn(Opcodes.RETURN);

        
        main.visitMaxs(0, 0);
        main.visitEnd();

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b, "program7.class");

        System.out.println("Done!");
    }
}

