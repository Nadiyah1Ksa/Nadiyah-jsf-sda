package com.app.bo.impl;

import java.awt.AlphaComposite;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.app.bo.FileManagerBO;
import com.app.exception.FileNameNotFoundException;
import com.app.exception.AlphaNumericOnly;
import com.app.model.FileDetail;

@SuppressWarnings("unused")
public class FileManagerBOImpl implements FileManagerBO {
	private File root;

	public FileManagerBOImpl(String root) {
		this.root = new File(root);
		try {
			this.root.mkdirs();
		} catch (SecurityException e) {
			System.out.println("Please provide access to C:\\");
			System.exit(0);
		}
	}

	@Override
	public FileDetail createFile(String name) throws IOException, SecurityException, AlphaNumericOnly {
		if(name.contains(".")) {
			if(!name.substring(0,name.lastIndexOf(".")).toLowerCase().matches("^[A-Za-z0-9\\s]+$")) {
				throw new AlphaNumericOnly("Only alphanumeric allowed");
			}
		}else {
			if(!name.toLowerCase().matches("^[A-Za-z0-9\\s]+$")) {
				throw new AlphaNumericOnly("Only alphanumeric allowed");
			}
		}		
		String path = root.getAbsolutePath();
		File newFIle = new File(path + "\\" + name);
		newFIle.createNewFile();
		return new FileDetail(newFIle.getName(), newFIle.getParent(), newFIle.length(), newFIle.getPath());

	}

	@Override
	public boolean deleteFile(String name) throws FileNameNotFoundException {
		String path = root.getAbsolutePath();
		File fIleToDelete = new File(path + "\\" + name);
		if(!fIleToDelete.exists()) {
			throw new FileNameNotFoundException(name);
		}
		if (fIleToDelete.exists()) {
			return fIleToDelete.delete();
		} else {
			throw new FileNameNotFoundException(name);
		}

	}

	@Override
	public List<FileDetail> getAllFiles() {
		File Files[] = this.root.listFiles();
		List<FileDetail> ListFiieDetail = new LinkedList<>();
		for (File file : Files) {
			ListFiieDetail.add(new FileDetail(file.getName(), file.getParent(), file.length(), file.getPath()));
		}

		return ListFiieDetail;
	}

	@Override
	public boolean searchFile(String name) {
		String path = root.getAbsolutePath();
		File fIleToSearch = new File(path + "\\" + name);
		return fIleToSearch.exists();
	}

}
