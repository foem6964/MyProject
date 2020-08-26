package kr.co.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class Utils {

	public static String getOriginalFilePath(String filename) {
		int idx = filename.indexOf("_");
		String datePath = filename.substring(0, idx - 1);
		String uidName = filename.substring(idx + 1);
		return datePath + uidName;
	}

	public static String getCutLastUnderBar(String filename) {
		int idx = filename.lastIndexOf('_');
		String originalName = filename.substring(idx + 1);
		return originalName;
	}

	public static String getFormat(String filename) {
		int idx = filename.lastIndexOf('.');
		String format = filename.substring(idx + 1);
		return format;
	}

	public static String saveFile(MultipartFile file, String uploadPath) throws IOException {
		String originalName = file.getOriginalFilename();
		String uidName = makeUidFileName(originalName);
		String datePath = makeCalendarDir(uploadPath);

		File target = new File(uploadPath + datePath, uidName);
		fileCopy(file, target);

		if (isImgFile(originalName)) {
			return makeThumbnail(uploadPath, datePath, uidName);
		} else {
			String beforchangeName = datePath + File.separator + uidName;
			return beforchangeName.replace(File.separatorChar, '/');
		}
	}

	private static String makeUidFileName(String originalName) {
		UUID uid = UUID.randomUUID();
		String uidName = uid.toString() + "_" + originalName;
		return uidName;
	}

	private static String makeCalendarDir(String uploadPath) {
		String[] paths = Utils.getDateInfoArr();
		File f = new File(uploadPath + paths[2]);
		if (f.exists()) {
			return paths[2];
		}

		for (String path : paths) {
			File dirPath = new File(uploadPath + path);
			if (!dirPath.exists())
				dirPath.mkdir();
		}
		return paths[2];
	}

	private static String[] getDateInfoArr() {
		Calendar cal = Calendar.getInstance();
		String year = File.separator + cal.get(Calendar.YEAR);
		String yearMonth = year + File.separator + String.format("%02d", cal.get(Calendar.MONTH) + 1);
		String yearMonthDate = yearMonth + File.separator + String.format("%02d", cal.get(Calendar.DATE));
		String[] paths = { year, yearMonth, yearMonthDate };
		return paths;
	}

	private static void fileCopy(MultipartFile file, File target) {
		try {
			FileCopyUtils.copy(file.getBytes(), target);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static boolean isImgFile(String filename) {
		String format = filename.substring(filename.lastIndexOf(".") + 1);
		MediaType mType = getMediaType(format);
		if (mType != null)
			return true;
		else
			return false;
	}

	private static String makeThumbnail(String uploadPath, String datePath, String uidName) throws IOException {
		File f1 = new File(uploadPath + datePath, uidName);
		BufferedImage sourceImg = ImageIO.read(f1);
		// 원본 이미지를 정확하게 100 크기로 맞추기 // 이미지, 자동(가로), 이미지깨질수잇음. 세로100
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_EXACT, 100);
		String thumbnailName = datePath + File.separator + "s_" + uidName;
		String thumbnailNamePath = uploadPath + thumbnailName;
		File newFile = new File(thumbnailNamePath);

		int idx = uidName.lastIndexOf(".");
		String format = uidName.substring(idx + 1).toUpperCase();
		// destImg 이미지를, 이 포멧상태로(JEPG), 이파일(newFile) 저장해주세요
		ImageIO.write(destImg, format, newFile);
		return thumbnailName.toUpperCase().replace(File.separatorChar, '/');
	}

	public static MediaType getMediaType(String format) {
		Map<String, MediaType> map = new HashMap<String, MediaType>();
		map.put("JPG", MediaType.IMAGE_JPEG);
		map.put("JPEG", MediaType.IMAGE_JPEG);
		map.put("PNG", MediaType.IMAGE_PNG);
		map.put("GIF", MediaType.IMAGE_GIF);

		MediaType mType = map.get(format.toUpperCase());
		return mType;
	}

	private static String getDateDirPath(String filename) {
		int idx = filename.indexOf('_');
		String datePath = filename.substring(0, idx - 1);
		return datePath;
	}

	public static void deletefile(String uploadPath, String filename) {
		File file = new File(uploadPath + filename);
		if (file.exists()) {
			if (file.delete()) {
				System.out.println("썸네일파일삭제 성공");
			} else {
				System.out.println("썸네일파일삭제 실패");
			}
		} else {
			System.out.println("썸네일파일이 존재하지 않습니다.");
		}
		File orgFile = new File(uploadPath + Utils.getOriginalFilePath(filename));
		if (orgFile.exists()) {
			if (orgFile.delete()) {
				System.out.println("파일삭제 성공");
			} else {
				System.out.println("파일삭제 실패");
			}
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		String datePath = getDateDirPath(filename);
		File DataPathDir = new File(uploadPath + datePath);
		if (DataPathDir.exists()) {
			if (DataPathDir.isDirectory()) {
				if (DataPathDir.delete()) {
					System.out.println("파일경로삭제 성공");
				} else {
					System.out.println("파일경로삭제 실패+디렉터리 폴더안에 파일이 존재합니다.");
				}
			} else {
				System.out.println("파일이 디렉토리가 아닙니다.");
			}
		} else {
			System.out.println("파일경로가 존재하지않습니다.");
		}

	}
}
