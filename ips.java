import java.util.Scanner;
public class ips {
	public static void main(String[] args) {
		System.out.println("Введите начало диапазона:");
		Scanner sScan = new Scanner(System.in);
		String sRangeStr = sScan.nextLine();
		String[] sSubStr;
		sSubStr = sRangeStr.split("\\.");
		System.out.println("Введите конец диапазона:");
		Scanner eScan = new Scanner(System.in);
		String eRangeStr = eScan.nextLine();
		String[] eSubStr;
		eSubStr = eRangeStr.split("\\.");

		System.out.println("\nДиапазон адресов:");

		if(sSubStr.length == 4 && eSubStr.length == 4) {
			Long startRange[]; startRange = new Long[4];
			Long endRange[]; endRange = new Long[4];
			Long newIp[]; newIp = new Long[4];
			for (int i = 0; i < 4; i++) {
				startRange[i] = new Long(sSubStr[i]);
				endRange[i] = new Long(eSubStr[i]);
			}
			
			Long startIpInDec = startRange[0]*256*256*256+startRange[1]*256*256+startRange[2]*256+startRange[3];
			Long endIpInDec = endRange[0]*256*256*256+endRange[1]*256*256+endRange[2]*256+endRange[3];

			for(;startIpInDec <= endIpInDec; startIpInDec++) {
				newIp[0]=(long)(startIpInDec/256/256/256);
				newIp[1]=(long)((startIpInDec-newIp[0]*256*256*256)/256/256);
				newIp[2]=(long)((startIpInDec-newIp[0]*256*256*256-newIp[1]*256*256)/256);
				newIp[3]=startIpInDec-newIp[0]*256*256*256-newIp[1]*256*256-newIp[2]*256;
				System.out.println(newIp[0] + "." + newIp[1] + "." + newIp[2] + "." + newIp[3]);
			}
		}
	}
}