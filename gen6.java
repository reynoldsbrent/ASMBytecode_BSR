/**Get input from the user using the Scanner class (I, L, and D)
 * Author: Brent Reynolds
*/

import static utils.Utilities.writeFile;
import org.objectweb.asm.*;

public class gen6 {

    public static void main(String[] args) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "program6", null, "java/lang/Object", null);

        
        MethodVisitor constructor = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        constructor.visitCode();
        constructor.visitVarInsn(Opcodes.ALOAD, 0);
        constructor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        constructor.visitInsn(Opcodes.RETURN);
        constructor.visitMaxs(1, 1);
        constructor.visitEnd();

        
        MethodVisitor main = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        main.visitCode();

        // Initialize scanner and accumulator variables
        main.visitTypeInsn(Opcodes.NEW, "java/util/Scanner");
        main.visitInsn(Opcodes.DUP);
        main.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");
        main.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false);
        main.visitVarInsn(Opcodes.ASTORE, 1); // Store Scanner object 

        // Read in user int input
        main.visitVarInsn(Opcodes.ALOAD, 1); // Load Scanner
        main.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        main.visitLdcInsn("Enter an integer: ");
        main.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
        main.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false);
        main.visitVarInsn(Opcodes.ISTORE, 3);

        // Read in user long input
        main.visitVarInsn(Opcodes.ALOAD, 1); // Load Scanner 
        main.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        main.visitLdcInsn("Enter a long: ");
        main.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
        main.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextLong", "()J", false);
        main.visitVarInsn(Opcodes.LSTORE, 2);

        // Read in user double input
        main.visitVarInsn(Opcodes.ALOAD, 1); // Load Scanner
        main.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        main.visitLdcInsn("Enter a double: ");
        main.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
        main.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextDouble", "()D", false);
        main.visitVarInsn(Opcodes.DSTORE, 4);

        // Print out user input
        main.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        main.visitVarInsn(Opcodes.ILOAD, 3);
        main.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

        main.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        main.visitVarInsn(Opcodes.LLOAD, 2);
        main.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);

        main.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        main.visitVarInsn(Opcodes.DLOAD, 4);
        main.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);

        
        main.visitInsn(Opcodes.RETURN);

        
        main.visitMaxs(0, 0);
        main.visitEnd();

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b, "program6.class");

        System.out.println("Done!");
    }
}

