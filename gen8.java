/** Implement If. . . Then . . . Else 
 * Author: Brent Reynolds
*/

import static utils.Utilities.writeFile;
import org.objectweb.asm.*;

public class gen8 {

    public static void main(String[] args) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "program8", null, "java/lang/Object", null);

       
        MethodVisitor constructor = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        constructor.visitCode();
        constructor.visitVarInsn(Opcodes.ALOAD, 0);
        constructor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        constructor.visitInsn(Opcodes.RETURN);
        constructor.visitMaxs(1, 1);
        constructor.visitEnd();

        
        MethodVisitor main = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        main.visitCode();

        // If
        main.visitInsn(Opcodes.ICONST_1); // Load true. The value of the condition check
        Label elseLabel = new Label();
        Label endLabel = new Label();
        main.visitJumpInsn(Opcodes.IFEQ, elseLabel); // If condition is false, jump to else label

        // Then. Print "True condition"
        main.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        main.visitLdcInsn("True condition");
        main.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        main.visitJumpInsn(Opcodes.GOTO, endLabel); // Jump to end label

        // Else. Print "False condition"
        main.visitLabel(elseLabel);
        main.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        main.visitLdcInsn("False condition");
        main.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

        main.visitLabel(endLabel);

        main.visitInsn(Opcodes.RETURN);

        main.visitMaxs(0, 0);
        main.visitEnd();

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b, "program8.class");

        System.out.println("Done!");
    }
}
