import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class gen3 {

    public static void main(String[] args) {

       
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "program3", null, "java/lang/Object", null);

        
        {
            MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(Opcodes.ALOAD, 0); 
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        
        {
            MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();

            // Divide two integers
            mv.visitLdcInsn(20); // Load first integer
            mv.visitLdcInsn(5); // Load second integer
            mv.visitInsn(Opcodes.IDIV); // Divide
            mv.visitVarInsn(Opcodes.ISTORE, 1); // Store result in local variable 1
            // Print the result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 1); // Load the stored result
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

            // Divide two longs
            mv.visitLdcInsn(100L); // Load first long
            mv.visitLdcInsn(10L); // Load second long
            mv.visitInsn(Opcodes.LDIV); // Divide
            mv.visitVarInsn(Opcodes.LSTORE, 3); // Store result in local variable 3
            // Print the result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 3); // Load the stored result
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);

            // Divide two floats
            mv.visitLdcInsn(10.5f); // Load first float
            mv.visitLdcInsn(3.0f); // Load second float
            mv.visitInsn(Opcodes.FDIV); // Divide
            mv.visitVarInsn(Opcodes.FSTORE, 5); // Store result in local variable 5
            // Print the result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.FLOAD, 5); // Load the stored result
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);

            // Divide two doubles
            mv.visitLdcInsn(15.0); // Load first double
            mv.visitLdcInsn(3.0); // Load second double
            mv.visitInsn(Opcodes.DDIV); // Divide
            mv.visitVarInsn(Opcodes.DSTORE, 7); // Store result in local variable 7
            // Print the result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.DLOAD, 7); // Load the stored result
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);

            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b, "program3.class");

        System.out.println("Done!");
    }
}
