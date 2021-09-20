import static util.Utilities.writeFile;

import org.objectweb.asm.*;

public class Compare2Numbers {
	public static void main(String[] args){

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"CompareNum", null, "java/lang/Object",null);
        
        {
			MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(Opcodes.ALOAD, 0); //load the first local variable: this
			mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V",false);
			mv.visitInsn(Opcodes.RETURN);
			mv.visitMaxs(1,1);
			mv.visitEnd();
		}
        
        { //Compare
          //Prints 1 if the first number is larger and -1 if the 2nd is larger
            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            //Int
            mv.visitIntInsn(Opcodes.BIPUSH, 50);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;" , false);
            mv.visitVarInsn(Opcodes.ASTORE,1);
            mv.visitIntInsn(Opcodes.BIPUSH, 10);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;" , false);
            mv.visitVarInsn(Opcodes.ASTORE,2);
            mv.visitFieldInsn(Opcodes.GETSTATIC,"java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ALOAD,1);
            mv.visitVarInsn(Opcodes.ALOAD,2);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "compareTo", "(Ljava/lang/Integer;)I", false);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }
        
        cw.visitEnd();
        
        byte[] b = cw.toByteArray();

        writeFile(b,"CompareNum.class");
        
        System.out.println("Done!");
	} //end main
}//end Compare2Numbers