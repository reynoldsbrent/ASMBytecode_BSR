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
            mv.visitVarInsn(Opcodes.ALOAD, 0); // load the first local variable: this
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        
        {
            MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();

            // Subtract two integers
            mv.visitLdcInsn(20); // Load first integer
            mv.visitLdcInsn(10); // Load second integer
            mv.visitInsn(Opcodes.ISUB); // Subtract
            mv.visitVarInsn(Opcodes.ISTORE, 1); // Store result in local variable 1
            // Print the result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 1); // Load the stored result
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

            // Subtract two longs
            mv.visitLdcInsn(100L); // Load first long
            mv.visitLdcInsn(50L); // Load second long
            mv.visitInsn(Opcodes.LSUB); // Subtract
            mv.visitVarInsn(Opcodes.LSTORE, 3); // Store result in local variable 3
            // Print the result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 3); // Load the stored result
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);

            // Subtract two floats
            mv.visitLdcInsn(10.5f); // Load first float
            mv.visitLdcInsn(3.2f); // Load second float
            mv.visitInsn(Opcodes.FSUB); // Subtract
            mv.visitVarInsn(Opcodes.FSTORE, 5); // Store result in local variable 5
            // Print the result
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.FLOAD, 5); // Load the stored result
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);

            // Subtract two doubles
            mv.visitLdcInsn(3.14); // Load first double
            mv.visitLdcInsn(2.5); // Load second double
            mv.visitInsn(Opcodes.DSUB); // Subtract
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

        writeFile(b, "program2.class");

        System.out.println("Done!");
    }
}

