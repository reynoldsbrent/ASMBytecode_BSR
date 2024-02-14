import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class gen1 {

    public static void main(String[] args) {

       
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "program1", null, "java/lang/Object", null);

        
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

            // Multiply two integers
            mv.visitLdcInsn(5); // Load first integer
            mv.visitLdcInsn(10); // Load second integer
            mv.visitInsn(Opcodes.IMUL); // Multiply
            mv.visitVarInsn(Opcodes.ISTORE, 1); // Store result in local variable 1
            // Print the result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 1); // Load the stored result
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

            // Multiply two longs
            mv.visitLdcInsn(100000L); // Load first long
            mv.visitLdcInsn(50000L); // Load second long
            mv.visitInsn(Opcodes.LMUL); // Multiply
            mv.visitVarInsn(Opcodes.LSTORE, 3); // Store result in local variable 3
            // Print the result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 3); // Load the stored result
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);

            // Multiply two floats
            mv.visitLdcInsn(10.5f); // Load first float
            mv.visitLdcInsn(3.2f); // Load second float
            mv.visitInsn(Opcodes.FMUL); // Multiply
            mv.visitVarInsn(Opcodes.FSTORE, 5); // Store result in local variable 5
            // Print the result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.FLOAD, 5); // Load the stored result
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);

            // Multiply two doubles
            mv.visitLdcInsn(3.14); // Load first double
            mv.visitLdcInsn(2.5); // Load second double
            mv.visitInsn(Opcodes.DMUL); // Multiply
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

        writeFile(b, "program1.class");

        System.out.println("Done!");
    }
}
