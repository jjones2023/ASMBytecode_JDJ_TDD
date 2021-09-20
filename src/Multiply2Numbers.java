import static util.Utilities.writeFile;

import org.objectweb.asm.*;

public class Multiply2Numbers {
	public static void main(String[] args){

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"MultiNum", null, "java/lang/Object",null);
        
        {
			MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(Opcodes.ALOAD, 0); //load the first local variable: this
			mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V",false);
			mv.visitInsn(Opcodes.RETURN);
			mv.visitMaxs(1,1);
			mv.visitEnd();
		}
        
        { //Multiply Int
            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            //int
            mv.visitCode();
            mv.visitLdcInsn((Integer)173);
            mv.visitVarInsn(Opcodes.ISTORE,1);
            mv.visitLdcInsn((Integer)45);
            mv.visitVarInsn(Opcodes.ISTORE,3);
            mv.visitVarInsn(Opcodes.ILOAD,1);
            mv.visitVarInsn(Opcodes.ILOAD,3);
            mv.visitInsn(Opcodes.IMUL);
            mv.visitVarInsn(Opcodes.ISTORE,5);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            //Double
            mv.visitLdcInsn((Double)169.12);
            mv.visitVarInsn(Opcodes.DSTORE,6);
            mv.visitLdcInsn((Double)45.20);
            mv.visitVarInsn(Opcodes.DSTORE,8);
            mv.visitVarInsn(Opcodes.DLOAD,6);
            mv.visitVarInsn(Opcodes.DLOAD,8);
            mv.visitInsn(Opcodes.DMUL);
            mv.visitVarInsn(Opcodes.DSTORE,10);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.DLOAD, 10);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);
            //Long
            mv.visitCode();
            mv.visitLdcInsn((long)173000L);
            mv.visitVarInsn(Opcodes.LSTORE,11);
            mv.visitLdcInsn((long)45000L);
            mv.visitVarInsn(Opcodes.LSTORE,13);
            mv.visitVarInsn(Opcodes.LLOAD,11);
            mv.visitVarInsn(Opcodes.LLOAD,13);
            mv.visitInsn(Opcodes.LMUL);
            mv.visitVarInsn(Opcodes.LSTORE,15);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 15);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
            
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }
        
        cw.visitEnd();
        
        byte[] b = cw.toByteArray();

        writeFile(b,"MultiNum.class");
        
        System.out.println("Done!");
	} //end main
}//end Multiply2Numbers