import java.io.File;

public class FileDeleter {
	void exeFileTerminator(File Obj) throws Exception{
		boolean delResult;
		String path=Obj.getAbsolutePath();
		String revPath=null;
		for(int i=(path.length()-1);i>=0;i--)
			revPath=revPath+path.charAt(i);
		if(revPath.toLowerCase().contains("exe.")){
			delResult=DeleteFile(path);
			if(!delResult)
				throw new Exception("Deleting exe file error");
		}
	}
	boolean DeleteFile(String exePath){
		File Obj=new File(exePath);
		boolean delResult=Obj.delete();
		return delResult;
	}
}
