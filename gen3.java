/** Divide two numbers (I, L, F, and D), store them, and then print each result 
 * Author: Brent Reynolds
*/

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

            // Divide two ints
            mv.visitLdcInsn(25); // First int loaded
            mv.visitLdcInsn(15); // Second int loaded
            mv.visitInsn(Opcodes.IDIV); // Divide the two ints
            mv.visitVarInsn(Opcodes.ISTORE, 1); // Store result 
            // Print result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

            // Divide two longs
            mv.visitLdcInsn(50L); // First long
            mv.visitLdcInsn(20L); // Second long
            mv.visitInsn(Opcodes.LDIV); // Divide the two longs
            mv.visitVarInsn(Opcodes.LSTORE, 3); // Store result
            // Print out result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 3); 
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);

            // Divide two floats
            mv.visitLdcInsn(15.5f); // First float
            mv.visitLdcInsn(5.5f); // Second float
            mv.visitInsn(Opcodes.FDIV); // Divide the two floats
            mv.visitVarInsn(Opcodes.FSTORE, 5); // Store result of division
            // Print out result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.FLOAD, 5); 
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);

            // Divide two doubles
            mv.visitLdcInsn(15.5); // First double
            mv.visitLdcInsn(10.0); // Second double
            mv.visitInsn(Opcodes.DDIV); // Divide the two doubles
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

        writeFile(b, "program3.class");

        System.out.println("Done!");
    }
}
