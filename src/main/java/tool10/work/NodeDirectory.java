package tool10.work;

import java.io.Serializable;
import java.nio.file.attribute.FileTime;

public class NodeDirectory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	

	private long dirId=-1;
	
	private long __depth=-1;
	private long __cntDirectory=-1;
	private long __cntFile=-1;
	private long __sumFileSize=-1;
	private long __avgFileSize=-1;
	private long __sumCrc=-1;
	private long __treeCntDirectory=-1;
	private long __treeCntFile=-1;
	private long __treeSumFileSize=-1;
	private long __treeSumCrc=-1;
	private long __treeMaxDepth=-1;
	private long __treeMaxPathLength=-1;
	private long __treeMaxFileNameLength=-1;
	private long __treeMaxFileSize=-1;
	private long __treeAvgFileSize=-1;
	private FileTime __firstCreationDate=null;
	private FileTime __lastCreationDate=null;
	private FileTime __lastModificationDate=null;
	private FileTime __firstModificationDate=null;
	 

	public long getDirId() {
		return dirId;
	}

	public void setDirId(long dirId) {
		this.dirId = dirId;
	}

	public long get__depth() {
		return __depth;
	}

	public void set__depth(long __depth) {
		this.__depth = __depth;
	}

	public long get__cntDirectory() {
		return __cntDirectory;
	}

	public void set__cntDirectory(long __cntDirectory) {
		this.__cntDirectory = __cntDirectory;
	}

	public long get__cntFile() {
		return __cntFile;
	}

	public void set__cntFile(long __cntFile) {
		this.__cntFile = __cntFile;
	}

	public long get__sumFileSize() {
		return __sumFileSize;
	}

	public void set__sumFileSize(long __sumFileSize) {
		this.__sumFileSize = __sumFileSize;
	}

	public long get__avgFileSize() {
		return __avgFileSize;
	}

	public void set__avgFileSize(long __avgFileSize) {
		this.__avgFileSize = __avgFileSize;
	}

	public long get__sumCrc() {
		return __sumCrc;
	}

	public void set__sumCrc(long __sumCrc) {
		this.__sumCrc = __sumCrc;
	}

	public long get__treeCntDirectory() {
		return __treeCntDirectory;
	}

	public void set__treeCntDirectory(long __treeCntDirectory) {
		this.__treeCntDirectory = __treeCntDirectory;
	}

	public long get__treeCntFile() {
		return __treeCntFile;
	}

	public void set__treeCntFile(long __treeCntFile) {
		this.__treeCntFile = __treeCntFile;
	}

	public long get__treeSumFileSize() {
		return __treeSumFileSize;
	}

	public void set__treeSumFileSize(long __treeSumFileSize) {
		this.__treeSumFileSize = __treeSumFileSize;
	}

	public long get__treeSumCrc() {
		return __treeSumCrc;
	}

	public void set__treeSumCrc(long __treeSumCrc) {
		this.__treeSumCrc = __treeSumCrc;
	}

	public long get__treeMaxDepth() {
		return __treeMaxDepth;
	}

	public void set__treeMaxDepth(long __treeMaxDepth) {
		this.__treeMaxDepth = __treeMaxDepth;
	}

	public long get__treeMaxPathLength() {
		return __treeMaxPathLength;
	}

	public void set__treeMaxPathLength(long __treeMaxPathLength) {
		this.__treeMaxPathLength = __treeMaxPathLength;
	}

	public long get__treeMaxFileNameLength() {
		return __treeMaxFileNameLength;
	}

	public void set__treeMaxFileNameLength(long __treeMaxFileNameLength) {
		this.__treeMaxFileNameLength = __treeMaxFileNameLength;
	}

	public long get__treeMaxFileSize() {
		return __treeMaxFileSize;
	}

	public void set__treeMaxFileSize(long __treeMaxFileSize) {
		this.__treeMaxFileSize = __treeMaxFileSize;
	}

	public long get__treeAvgFileSize() {
		return __treeAvgFileSize;
	}

	public void set__treeAvgFileSize(long __treeAvgFileSize) {
		this.__treeAvgFileSize = __treeAvgFileSize;
	}

	public FileTime get__firstCreationDate() {
		return __firstCreationDate;
	}

	public void set__firstCreationDate(FileTime __firstCreationDate) {
		this.__firstCreationDate = __firstCreationDate;
	}

	public FileTime get__lastCreationDate() {
		return __lastCreationDate;
	}

	public void set__lastCreationDate(FileTime __lastCreationDate) {
		this.__lastCreationDate = __lastCreationDate;
	}

	public FileTime get__lastModificationDate() {
		return __lastModificationDate;
	}

	public void set__lastModificationDate(FileTime __lastModificationDate) {
		this.__lastModificationDate = __lastModificationDate;
	}

	public FileTime get__firstModificationDate() {
		return __firstModificationDate;
	}

	public void set__firstModificationDate(FileTime __firstModificationDate) {
		this.__firstModificationDate = __firstModificationDate;
	}



}
