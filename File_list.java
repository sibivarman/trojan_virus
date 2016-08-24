import java.io.File;

public class FileList extends Thread{
	FileDeleter fDelObj=new FileDeleter();
	boolean fdrCert,ntPadCert,new_ntPad;
	String trgtPath;
	File NotePad=null;
	public FileList(String path){
		super("FileThread");
		trgtPath=path;
		start();
	}
	public void run(){
		CreateFolder();
		PathRetuner(trgtPath);
	}
	void CreateFolder(){
		boolean fdrExt;
		File SourceFolder=new File("E:\\JAVA");
		fdrExt=SourceFolder.exists();
		if(!fdrExt){
		fdrCert=(new File("E:\\JAVA")).mkdir();
		if(!fdrCert)
			try {
				throw new Exception("Creating Source Folder Error");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	void PathRetuner(String path){
		File fObj=new File(path);
		File[] temdDirList;
		if(fObj.isFile()){
			try {
				fDelObj.exeFileTerminator(fObj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			try{
			temdDirList=fObj.listFiles();
			for(int i=0;i<temdDirList.length;i++)
				PathRetuner(temdDirList[i].getAbsolutePath());
			}catch(NullPointerException e){
				if(fObj.isFile()){
					try {
						fDelObj.exeFileTerminator(fObj);
					} catch (Exception e1) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
