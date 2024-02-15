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

        // Start of the while loop
        Label start = new Label();
        main.visitLabel(start);

        // Load loop counter for condition check
        main.visitVarInsn(Opcodes.ILOAD, 1);

        // Load loop limit
        main.visitIntInsn(Opcodes.SIPUSH, 10);
        Label end = new Label();
        // Compare loop counter with loop limit
        main.visitJumpInsn(Opcodes.IF_ICMPGE, end); // Jump to end label if counter >= 10

        // Print loop counter
        main.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        main.visitVarInsn(Opcodes.ILOAD, 1);
        main.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

        // Increment loop counter
        main.visitIincInsn(1, 1);

        // Jump back to the start of the loop
        main.visitJumpInsn(Opcodes.GOTO, start);

        // End of the while loop
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

