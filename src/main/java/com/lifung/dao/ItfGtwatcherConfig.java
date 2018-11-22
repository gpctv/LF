// default package
// Generated 2018/4/19 ?? 06:11:16 by Hibernate Tools 3.4.0.CR1
package com.lifung.dao;
import java.util.Date;

/**
 * ItfGtwatcherConfig generated by hbm2java
 */
public class ItfGtwatcherConfig implements java.io.Serializable {

	private int watcherConfigKey;
	private String datastream;
	private String watchFolder;
	private String activeFlag;
	private String moveToFolder;
	private String archiveFolder;
	private String failFolder;
	private String backupFolder;
	private int ftpServerId;
	private String ftpWipfolder;
	private String ftpFolder;
	private String ftpArcFolder;
	private String ftpDirection;
	private String filePreFixed;
	private String fileExt;
	private String fileRegExpression;
	private String fileCompression;
	private String filePrefixAddOn;
	private String fileCompressPreFixed;
	private String fileCompressExt;
	private String fileCompressRegExpression;
	private String fileAttachment;
	private String mailSubject;
	private String mailText1;
	private String mailText2;
	private String mailTo;
	private String mailCc;
	private String failMailTo;
	private String failMailCc;
	private Date addDate;
	private String addWho;
	private Date editDate;
	private String editWho;
	private String dynamicFilename;
	private Date lastProcessDate;
	private String postingSp;
	private Integer maxFileCount;
	private String moveToFolder2;
	private String moveToFolder3;
	private String moveToFolder4;
	private String moveToFolder5;
	private byte autoImportFlag;
	private String moveToFolder6;
	private String moveToFolder7;
	private String moveToFolder8;
	private String moveToFolder9;
	private String moveToFolder10;

	public ItfGtwatcherConfig() {
	}

	public ItfGtwatcherConfig(int watcherConfigKey, String datastream, String watchFolder, String activeFlag,
			String moveToFolder, int ftpServerId, Date lastProcessDate, byte autoImportFlag) {
		this.watcherConfigKey = watcherConfigKey;
		this.datastream = datastream;
		this.watchFolder = watchFolder;
		this.activeFlag = activeFlag;
		this.moveToFolder = moveToFolder;
		this.ftpServerId = ftpServerId;
		this.lastProcessDate = lastProcessDate;
		this.autoImportFlag = autoImportFlag;
	}

	public ItfGtwatcherConfig(int watcherConfigKey, String datastream, String watchFolder, String activeFlag,
			String moveToFolder, String archiveFolder, String failFolder, String backupFolder, int ftpServerId,
			String ftpWipfolder, String ftpFolder, String ftpArcFolder, String ftpDirection, String filePreFixed,
			String fileExt, String fileRegExpression, String fileCompression, String filePrefixAddOn,
			String fileCompressPreFixed, String fileCompressExt, String fileCompressRegExpression,
			String fileAttachment, String mailSubject, String mailText1, String mailText2, String mailTo, String mailCc,
			String failMailTo, String failMailCc, Date addDate, String addWho, Date editDate, String editWho,
			String dynamicFilename, Date lastProcessDate, String postingSp, Integer maxFileCount, String moveToFolder2,
			String moveToFolder3, String moveToFolder4, String moveToFolder5, byte autoImportFlag, String moveToFolder6,
			String moveToFolder7, String moveToFolder8, String moveToFolder9, String moveToFolder10) {
		this.watcherConfigKey = watcherConfigKey;
		this.datastream = datastream;
		this.watchFolder = watchFolder;
		this.activeFlag = activeFlag;
		this.moveToFolder = moveToFolder;
		this.archiveFolder = archiveFolder;
		this.failFolder = failFolder;
		this.backupFolder = backupFolder;
		this.ftpServerId = ftpServerId;
		this.ftpWipfolder = ftpWipfolder;
		this.ftpFolder = ftpFolder;
		this.ftpArcFolder = ftpArcFolder;
		this.ftpDirection = ftpDirection;
		this.filePreFixed = filePreFixed;
		this.fileExt = fileExt;
		this.fileRegExpression = fileRegExpression;
		this.fileCompression = fileCompression;
		this.filePrefixAddOn = filePrefixAddOn;
		this.fileCompressPreFixed = fileCompressPreFixed;
		this.fileCompressExt = fileCompressExt;
		this.fileCompressRegExpression = fileCompressRegExpression;
		this.fileAttachment = fileAttachment;
		this.mailSubject = mailSubject;
		this.mailText1 = mailText1;
		this.mailText2 = mailText2;
		this.mailTo = mailTo;
		this.mailCc = mailCc;
		this.failMailTo = failMailTo;
		this.failMailCc = failMailCc;
		this.addDate = addDate;
		this.addWho = addWho;
		this.editDate = editDate;
		this.editWho = editWho;
		this.dynamicFilename = dynamicFilename;
		this.lastProcessDate = lastProcessDate;
		this.postingSp = postingSp;
		this.maxFileCount = maxFileCount;
		this.moveToFolder2 = moveToFolder2;
		this.moveToFolder3 = moveToFolder3;
		this.moveToFolder4 = moveToFolder4;
		this.moveToFolder5 = moveToFolder5;
		this.autoImportFlag = autoImportFlag;
		this.moveToFolder6 = moveToFolder6;
		this.moveToFolder7 = moveToFolder7;
		this.moveToFolder8 = moveToFolder8;
		this.moveToFolder9 = moveToFolder9;
		this.moveToFolder10 = moveToFolder10;
	}

	public int getWatcherConfigKey() {
		return this.watcherConfigKey;
	}

	public void setWatcherConfigKey(int watcherConfigKey) {
		this.watcherConfigKey = watcherConfigKey;
	}

	public String getDatastream() {
		return this.datastream;
	}

	public void setDatastream(String datastream) {
		this.datastream = datastream;
	}

	public String getWatchFolder() {
		return this.watchFolder;
	}

	public void setWatchFolder(String watchFolder) {
		this.watchFolder = watchFolder;
	}

	public String getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getMoveToFolder() {
		return this.moveToFolder;
	}

	public void setMoveToFolder(String moveToFolder) {
		this.moveToFolder = moveToFolder;
	}

	public String getArchiveFolder() {
		return this.archiveFolder;
	}

	public void setArchiveFolder(String archiveFolder) {
		this.archiveFolder = archiveFolder;
	}

	public String getFailFolder() {
		return this.failFolder;
	}

	public void setFailFolder(String failFolder) {
		this.failFolder = failFolder;
	}

	public String getBackupFolder() {
		return this.backupFolder;
	}

	public void setBackupFolder(String backupFolder) {
		this.backupFolder = backupFolder;
	}

	public int getFtpServerId() {
		return this.ftpServerId;
	}

	public void setFtpServerId(int ftpServerId) {
		this.ftpServerId = ftpServerId;
	}

	public String getFtpWipfolder() {
		return this.ftpWipfolder;
	}

	public void setFtpWipfolder(String ftpWipfolder) {
		this.ftpWipfolder = ftpWipfolder;
	}

	public String getFtpFolder() {
		return this.ftpFolder;
	}

	public void setFtpFolder(String ftpFolder) {
		this.ftpFolder = ftpFolder;
	}

	public String getFtpArcFolder() {
		return this.ftpArcFolder;
	}

	public void setFtpArcFolder(String ftpArcFolder) {
		this.ftpArcFolder = ftpArcFolder;
	}

	public String getFtpDirection() {
		return this.ftpDirection;
	}

	public void setFtpDirection(String ftpDirection) {
		this.ftpDirection = ftpDirection;
	}

	public String getFilePreFixed() {
		return this.filePreFixed;
	}

	public void setFilePreFixed(String filePreFixed) {
		this.filePreFixed = filePreFixed;
	}

	public String getFileExt() {
		return this.fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public String getFileRegExpression() {
		return this.fileRegExpression;
	}

	public void setFileRegExpression(String fileRegExpression) {
		this.fileRegExpression = fileRegExpression;
	}

	public String getFileCompression() {
		return this.fileCompression;
	}

	public void setFileCompression(String fileCompression) {
		this.fileCompression = fileCompression;
	}

	public String getFilePrefixAddOn() {
		return this.filePrefixAddOn;
	}

	public void setFilePrefixAddOn(String filePrefixAddOn) {
		this.filePrefixAddOn = filePrefixAddOn;
	}

	public String getFileCompressPreFixed() {
		return this.fileCompressPreFixed;
	}

	public void setFileCompressPreFixed(String fileCompressPreFixed) {
		this.fileCompressPreFixed = fileCompressPreFixed;
	}

	public String getFileCompressExt() {
		return this.fileCompressExt;
	}

	public void setFileCompressExt(String fileCompressExt) {
		this.fileCompressExt = fileCompressExt;
	}

	public String getFileCompressRegExpression() {
		return this.fileCompressRegExpression;
	}

	public void setFileCompressRegExpression(String fileCompressRegExpression) {
		this.fileCompressRegExpression = fileCompressRegExpression;
	}

	public String getFileAttachment() {
		return this.fileAttachment;
	}

	public void setFileAttachment(String fileAttachment) {
		this.fileAttachment = fileAttachment;
	}

	public String getMailSubject() {
		return this.mailSubject;
	}

	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}

	public String getMailText1() {
		return this.mailText1;
	}

	public void setMailText1(String mailText1) {
		this.mailText1 = mailText1;
	}

	public String getMailText2() {
		return this.mailText2;
	}

	public void setMailText2(String mailText2) {
		this.mailText2 = mailText2;
	}

	public String getMailTo() {
		return this.mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String getMailCc() {
		return this.mailCc;
	}

	public void setMailCc(String mailCc) {
		this.mailCc = mailCc;
	}

	public String getFailMailTo() {
		return this.failMailTo;
	}

	public void setFailMailTo(String failMailTo) {
		this.failMailTo = failMailTo;
	}

	public String getFailMailCc() {
		return this.failMailCc;
	}

	public void setFailMailCc(String failMailCc) {
		this.failMailCc = failMailCc;
	}

	public Date getAddDate() {
		return this.addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public String getAddWho() {
		return this.addWho;
	}

	public void setAddWho(String addWho) {
		this.addWho = addWho;
	}

	public Date getEditDate() {
		return this.editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public String getEditWho() {
		return this.editWho;
	}

	public void setEditWho(String editWho) {
		this.editWho = editWho;
	}

	public String getDynamicFilename() {
		return this.dynamicFilename;
	}

	public void setDynamicFilename(String dynamicFilename) {
		this.dynamicFilename = dynamicFilename;
	}

	public Date getLastProcessDate() {
		return this.lastProcessDate;
	}

	public void setLastProcessDate(Date lastProcessDate) {
		this.lastProcessDate = lastProcessDate;
	}

	public String getPostingSp() {
		return this.postingSp;
	}

	public void setPostingSp(String postingSp) {
		this.postingSp = postingSp;
	}

	public Integer getMaxFileCount() {
		return this.maxFileCount;
	}

	public void setMaxFileCount(Integer maxFileCount) {
		this.maxFileCount = maxFileCount;
	}

	public String getMoveToFolder2() {
		return this.moveToFolder2;
	}

	public void setMoveToFolder2(String moveToFolder2) {
		this.moveToFolder2 = moveToFolder2;
	}

	public String getMoveToFolder3() {
		return this.moveToFolder3;
	}

	public void setMoveToFolder3(String moveToFolder3) {
		this.moveToFolder3 = moveToFolder3;
	}

	public String getMoveToFolder4() {
		return this.moveToFolder4;
	}

	public void setMoveToFolder4(String moveToFolder4) {
		this.moveToFolder4 = moveToFolder4;
	}

	public String getMoveToFolder5() {
		return this.moveToFolder5;
	}

	public void setMoveToFolder5(String moveToFolder5) {
		this.moveToFolder5 = moveToFolder5;
	}

	public byte getAutoImportFlag() {
		return this.autoImportFlag;
	}

	public void setAutoImportFlag(byte autoImportFlag) {
		this.autoImportFlag = autoImportFlag;
	}

	public String getMoveToFolder6() {
		return this.moveToFolder6;
	}

	public void setMoveToFolder6(String moveToFolder6) {
		this.moveToFolder6 = moveToFolder6;
	}

	public String getMoveToFolder7() {
		return this.moveToFolder7;
	}

	public void setMoveToFolder7(String moveToFolder7) {
		this.moveToFolder7 = moveToFolder7;
	}

	public String getMoveToFolder8() {
		return this.moveToFolder8;
	}

	public void setMoveToFolder8(String moveToFolder8) {
		this.moveToFolder8 = moveToFolder8;
	}

	public String getMoveToFolder9() {
		return this.moveToFolder9;
	}

	public void setMoveToFolder9(String moveToFolder9) {
		this.moveToFolder9 = moveToFolder9;
	}

	public String getMoveToFolder10() {
		return this.moveToFolder10;
	}

	public void setMoveToFolder10(String moveToFolder10) {
		this.moveToFolder10 = moveToFolder10;
	}

}
