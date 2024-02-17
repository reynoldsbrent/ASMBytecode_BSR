/** Subtract two numbers (I, L, F, and D), store them, and then print each result */

import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class gen2 {

    public static void main(String[] args) {

        
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "program2", null, "java/lang/Object", null);

        
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

            // Subtract two ints
            mv.visitLdcInsn(10); // First int loaded
            mv.visitLdcInsn(2); // Second int loaded
            mv.visitInsn(Opcodes.ISUB); // Subtract the two ints
            mv.visitVarInsn(Opcodes.ISTORE, 1); // Result of the subtraction stored in variable 1
            // Print out result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 1); 
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

            // Subtract two longs
            mv.visitLdcInsn(25L); // First long loaded
            mv.visitLdcInsn(5L); // Second long
            mv.visitInsn(Opcodes.LSUB); // Subtract the two longs
            mv.visitVarInsn(Opcodes.LSTORE, 3); // Result of the subtraction stored in variable 3
            // Print out the result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 3); 
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);

            // Subtract two floats
            mv.visitLdcInsn(5.5f); // First float
            mv.visitLdcInsn(1.5f); // Second float
            mv.visitInsn(Opcodes.FSUB); // Subtract the two floats
            mv.visitVarInsn(Opcodes.FSTORE, 5); // Result stored
            // Print out the result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.FLOAD, 5); 
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);

            // Subtract two doubles
            mv.visitLdcInsn(5.25); // First double
            mv.visitLdcInsn(2.25); // Second double
            mv.visitInsn(Opcodes.DSUB); // Subtract the two doubles
            mv.visitVarInsn(Opcodes.DSTORE, 7); // Store result
            // Print result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.DLOAD, 7);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);

            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b, "program2.class");

        System.out.println("Done!");
    }
}

