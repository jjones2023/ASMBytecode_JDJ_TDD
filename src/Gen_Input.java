import static util.Utilities.writeFile;

import org.objectweb.asm.*;

public class Gen_Input {
	public static void main(String[] args){
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"Scanner", null, "java/lang/Object",null);
    
		{
			MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC, "Scanner", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(Opcodes.ALOAD, 0);
			mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "Scanner", "(Ljava/io/InputStream;)V",false);
			mv.visitInsn(Opcodes.RETURN);
			mv.visitMaxs(1,1);
			mv.visitEnd();
		}
		
		{
			MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
			mv.visitCode();
			mv.visitFieldInsn(Opcodes.GETSTATIC,"java/lang/System", "in", "Ljava/io/InputStream;");
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Scanner", "Scanner", "(Ljava/io/InputStream;)V" , false);
            mv.visitVarInsn(Opcodes.ASTORE,1);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
			mv.visitInsn(Opcodes.RETURN);
			mv.visitMaxs(0,0);
			mv.visitEnd();
		}
      cw.visitEnd();
      byte[] b = cw.toByteArray();
      writeFile(b,"Scanner.class");
      System.out.println("Done!");
	}    
}