import static util.Utilities.writeFile;

import org.objectweb.asm.*;

public class declareString {
	public static void main(String [] args) {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"StringVar", null, "java/lang/Object",null);
        
        {
			MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(Opcodes.ALOAD, 0); //load the first local variable: this
			mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V",false);
			mv.visitInsn(Opcodes.RETURN);
			mv.visitMaxs(1,1);
			mv.visitEnd();
		}
        { //Declare String
        	MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        	mv.visitCode();
            mv.visitLdcInsn((String)"Hello World");
            mv.visitVarInsn(Opcodes.ASTORE, 1);
            mv.visitFieldInsn(Opcodes.GETSTATIC,"java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitInsn(Opcodes.RETURN);
			mv.visitMaxs(0,0);
			mv.visitEnd();
        }
        cw.visitEnd();
        byte[] b = cw.toByteArray();
        writeFile(b,"StringVar.class");
        System.out.println("Done!");
	}
}
