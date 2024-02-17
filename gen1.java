/** Multiply two numbers (I, L, F, and D), store them, and then print each result */

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
            mv.visitLdcInsn(5); // First int loaded
            mv.visitLdcInsn(2); // Second int loaded
            mv.visitInsn(Opcodes.IMUL); // Multiply the two ints
            mv.visitVarInsn(Opcodes.ISTORE, 1); // Result stored in variable 1
            // Print result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 1); // Result loaded
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

            // Multiply two longs
            mv.visitLdcInsn(10000L); // First long loaded
            mv.visitLdcInsn(20000L); // Second Long loaded
            mv.visitInsn(Opcodes.LMUL); // Multiply the two longs
            mv.visitVarInsn(Opcodes.LSTORE, 3); // Result stored in variable 3
            // Print result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 3); // Result loaded
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);

            // Multiply two floats
            mv.visitLdcInsn(10.5f); // First float loaded
            mv.visitLdcInsn(2.5f); // Second float loaded
            mv.visitInsn(Opcodes.FMUL); // Multiply the two floats
            mv.visitVarInsn(Opcodes.FSTORE, 5); // Result stored in variable 5
            // Print result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.FLOAD, 5); // Result loaded
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);

            // Multiply two doubles
            mv.visitLdcInsn(5.25); // First double loaded
            mv.visitLdcInsn(1.5); // Second double loaded
            mv.visitInsn(Opcodes.DMUL); // Multiply the two doubles
            mv.visitVarInsn(Opcodes.DSTORE, 7); // Result stored in variable 7
            // Print result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.DLOAD, 7); // Result loaded
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
