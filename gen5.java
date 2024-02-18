/** Declare and print String Variables
 * Author: Brent Reynolds
 */

import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

public class gen5 {

    public static void main(String[] args) {

        
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "program5", null, "java/lang/Object", null);

        
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

            // Declare and initialize strings
            mv.visitLdcInsn("Hello World!"); 
            mv.visitVarInsn(Opcodes.ASTORE, 1); // Store first string
            mv.visitLdcInsn("This is Brent!"); 
            mv.visitVarInsn(Opcodes.ASTORE, 2); // Store second string

            // Print the strings
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ALOAD, 1); // Load first string
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ALOAD, 2); // Load second string
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

           
            mv.visitInsn(Opcodes.RETURN);

            
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b, "program5.class");

        System.out.println("Done!");
    }
}

