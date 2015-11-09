
/*
Given two Lists, find values in the first list that are not in the second list and return those values in a third list
*/

/*
The 2nd implementation tries to reduce the time complexity.
It’s similar to the 1st one, except that we first put the second list in a HashSet. This will get all the unique elements into the Set. Moverover, all the elements were hashed to a certain bucket. This will reduce the look-up operation time later. Hashset has a O(1) lookup time complexity (worst case O(n) ).
*/


package Collec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NotInSecond {
	
	public static void main(String[] args)
	{
		long startTime = System.nanoTime();

				//List<Integer> la= Arrays.asList(1,2,3);
				List<Integer> la= Arrays.asList(1, 3, 5, 8, 9, 12, 18, 19, 20, 21, 24, 25, 27, 28, 32, 38, 40, 43, 46, 48, 51, 55, 62, 63, 64, 65, 66, 68, 71, 73, 74, 78, 79, 80, 85, 86, 87, 88, 89, 91, 92, 94, 95, 98, 99, 104, 107, 108, 109, 113, 114, 115, 116, 117, 119, 121, 132, 135, 136, 138, 139, 141, 145, 148, 149, 152, 153, 155, 156, 161, 162, 164, 165, 166, 167, 168, 169, 171, 172, 173, 174, 176, 178, 179, 181, 183, 184, 185, 189, 190, 194, 195, 198, 200, 201, 203, 205, 206, 207, 208, 210, 211, 212, 215, 218, 219, 222, 223, 225, 226, 232, 239, 241, 242, 243, 245, 246, 248, 251, 252, 254, 256, 257, 258, 259, 260, 261, 262, 263, 265, 266, 267, 276, 279, 282, 284, 285, 286, 288, 294, 297, 299, 300, 302, 303, 305, 306, 310, 311, 312, 313, 314, 316, 320, 321, 324, 327, 330, 332, 333, 335, 336, 341, 345, 347, 348, 349, 350, 354, 359, 360, 368, 369, 370, 372, 377, 380, 382, 385, 389, 390, 392, 393, 394, 397, 401, 403, 406, 408, 410, 414, 417, 421, 424, 431, 434, 439, 440, 442, 445, 449, 450, 451, 453, 456, 457, 462, 465, 467, 470, 472, 474, 476, 478, 479, 481, 482, 488, 491, 495, 496, 497, 498, 500, 502, 507, 508, 509, 510, 512, 515, 516, 517, 518, 521, 522, 523, 525, 526, 527, 528, 529, 530, 533, 534, 535, 537, 541, 546, 547, 549, 553, 555, 556, 557, 558, 560, 561, 562, 563, 564, 565, 568, 569, 570, 571, 572, 574, 576, 579, 582, 583, 585, 586, 588, 590, 593, 597, 598, 600, 605, 608, 611, 613, 615, 617, 618, 619, 621, 622, 623, 625, 628, 629, 631, 632, 634, 635, 636, 637, 638, 639, 641, 644, 645, 646, 647, 649, 650, 651, 652, 653, 654, 659, 663, 664, 665, 666, 667, 668, 669, 673, 676, 677, 679, 680, 682, 687, 690, 691, 692, 693, 694, 695, 698, 699, 704, 705, 710, 711, 713, 714, 718, 719, 721, 723, 725, 726, 727, 730, 732, 734, 736, 737, 740, 741, 742, 743, 746, 749, 751, 755, 756, 760, 761, 762, 764, 765, 766, 769, 770, 771, 772, 773, 774, 776, 777, 779, 780, 781, 782, 784, 786, 787, 789, 791, 792, 793, 794, 795, 796, 798, 801, 805, 808, 810, 817, 818, 819, 820, 821, 825, 827, 828, 829, 831, 835, 836, 839, 840, 841, 844, 847, 851, 854, 855, 856, 857, 858, 859, 860, 861, 863, 866, 867, 869, 870, 872, 873, 875, 876, 878, 879, 880, 881, 885, 886, 896, 897, 898, 899, 903, 904, 905, 907, 911, 912, 923, 928, 929, 930, 931, 932, 933, 936, 939, 940, 945, 946, 948, 951, 952, 953, 956, 960, 961, 962, 965, 966, 967, 968, 969, 971, 972, 974, 976, 982, 983, 984, 985, 986, 987, 988, 989, 990, 995, 996, 997, 998, 1003, 1004, 1005, 1006, 1011, 1013, 1014, 1015, 1016, 1019, 1020, 1023, 1024, 1027, 1028, 1030, 1032, 1033, 1034, 1035, 1036, 1043, 1045, 1046, 1048, 1049, 1050, 1051, 1054, 1058, 1059, 1060, 1062, 1063, 1067, 1068, 1069, 1070, 1071, 1073, 1074, 1075, 1076, 1078, 1080, 1081, 1083, 1084, 1087, 1091, 1092, 1093, 1094, 1095, 1096, 1099, 1101, 1103, 1105, 1107, 1109, 1110, 1111, 1113, 1118, 1124, 1127, 1129, 1131, 1133, 1136, 1137, 1138, 1139, 1141, 1142, 1146, 1147, 1149, 1151, 1153, 1155, 1160, 1161, 1162, 1163, 1166, 1168, 1169, 1170, 1172, 1178, 1179, 1180, 1181, 1182, 1183, 1185, 1187, 1189, 1191, 1194, 1195, 1196, 1197, 1205, 1210, 1211, 1212, 1216, 1217, 1218, 1219, 1220, 1221, 1225, 1229, 1231, 1232, 1237, 1239, 1240, 1241, 1243, 1244, 1246, 1248, 1253, 1254, 1256, 1257, 1259, 1262, 1263, 1270, 1273, 1274, 1275, 1277, 1279, 1280, 1286, 1288, 1289, 1290, 1292, 1294, 1296, 1297, 1298, 1306, 1307, 1308, 1309, 1311, 1312, 1313, 1314, 1315, 1318, 1321, 1322, 1324, 1327, 1328, 1330, 1331, 1333, 1334, 1335, 1336, 1343, 1344, 1345, 1346, 1349, 1350, 1352, 1353, 1355, 1357, 1360, 1362, 1363, 1364, 1365, 1368, 1369, 1372, 1374, 1375, 1377, 1379, 1381, 1384, 1385, 1387, 1388, 1392, 1393, 1396, 1397, 1398, 1404, 1408, 1409, 1410, 1411, 1415, 1416, 1419, 1420, 1422, 1424, 1426, 1428, 1429, 1432, 1435, 1438, 1439, 1441, 1443, 1445, 1446, 1447, 1448, 1450, 1451, 1452, 1453, 1456, 1457, 1464, 1466, 1467, 1468, 1469, 1470, 1472, 1476, 1477, 1478, 1479, 1482, 1483, 1484, 1485, 1487, 1489, 1490, 1493, 1494, 1497, 1500, 1501, 1502, 1504, 1507, 1508, 1509, 1512, 1519, 1522, 1525, 1528, 1529, 1530, 1536, 1537, 1538, 1541, 1542, 1543, 1548, 1549, 1550, 1556, 1558, 1560, 1561, 1562, 1563, 1566, 1567, 1568, 1572, 1573, 1576, 1578, 1579, 1580, 1582, 1583, 1587, 1589, 1590, 1591, 1593, 1595, 1607, 1608, 1609, 1610, 1611, 1614, 1618, 1621, 1623, 1625, 1626, 1629, 1632, 1633, 1634, 1641, 1642, 1643, 1644, 1645, 1647, 1648, 1652, 1654, 1655, 1657, 1660, 1661, 1663, 1664, 1665, 1670, 1673, 1675, 1677, 1678, 1679, 1680, 1681, 1683, 1685, 1689, 1690, 1692, 1694, 1695, 1696, 1697, 1700, 1703, 1705, 1707, 1709, 1710, 1711, 1713, 1715, 1718, 1719, 1722, 1724, 1725, 1726, 1728, 1730, 1732, 1740, 1741, 1745, 1747, 1750, 1753, 1754, 1755, 1757, 1759, 1760, 1762, 1765, 1767, 1768, 1772, 1774, 1776, 1777, 1778, 1781, 1782, 1783, 1785, 1786, 1787, 1791, 1793, 1795, 1796, 1799, 1800, 1803, 1810, 1812, 1814, 1815, 1818, 1819, 1822, 1825, 1826, 1827, 1830, 1831, 1832, 1833, 1835, 1836, 1837, 1838, 1840, 1841, 1842, 1843, 1844, 1845, 1846, 1849, 1850, 1851, 1859, 1860, 1861, 1862, 1863, 1864, 1865, 1866, 1869, 1871, 1877, 1879, 1880, 1883, 1886, 1888, 1894, 1896, 1897, 1898, 1899, 1900, 1901, 1902, 1904, 1905, 1906, 1909, 1910, 1911, 1913, 1914, 1915, 1919, 1920, 1921, 1922, 1923, 1924, 1926, 1927, 1928, 1930, 1932, 1933, 1936, 1937, 1938, 1939, 1941, 1942, 1945, 1949, 1950, 1954, 1955, 1956, 1957, 1958, 1962, 1964, 1965, 1968, 1969, 1970, 1971, 1973, 1974, 1975, 1976, 1977, 1978, 1982, 1983, 1985, 1987, 1988, 1989, 1991, 1993, 1994, 1996, 1998, 2000);
				List<Integer> lb= Arrays.asList(6, 7, 10, 11, 14, 15, 17, 21, 24, 26, 28, 30, 31, 35, 40, 42, 44, 46, 52, 53, 54, 55, 57, 62, 65, 68, 71, 72, 74, 75, 77, 79, 80, 81, 82, 83, 85, 88, 89, 92, 93, 99, 102, 104, 105, 107, 108, 109, 110, 113, 122, 123, 125, 126, 127, 134, 136, 138, 139, 140, 143, 144, 145, 148, 149, 150, 152, 153, 157, 159, 160, 165, 168, 171, 172, 179, 181, 182, 184, 186, 187, 188, 191, 202, 206, 208, 209, 211, 214, 216, 218, 220, 221, 228, 232, 234, 235, 241, 243, 246, 247, 248, 251, 252, 254, 257, 258, 260, 262, 265, 270, 271, 272, 273, 277, 278, 279, 281, 283, 284, 285, 286, 289, 290, 291, 292, 294, 296, 298, 299, 300, 302, 305, 309, 310, 315, 317, 319, 321, 326, 332, 335, 336, 337, 338, 339, 341, 342, 343, 347, 350, 351, 352, 353, 356, 358, 359, 360, 361, 364, 365, 367, 369, 371, 373, 376, 377, 379, 381, 384, 385, 387, 390, 395, 396, 397, 400, 401, 403, 406, 411, 412, 413, 417, 418, 419, 420, 421, 425, 426, 428, 429, 433, 434, 436, 437, 438, 440, 446, 447, 448, 450, 452, 454, 455, 456, 457, 462, 463, 464, 465, 466, 467, 469, 470, 473, 475, 476, 477, 479, 481, 484, 485, 487, 488, 495, 496, 498, 500, 501, 504, 505, 508, 509, 511, 512, 518, 519, 521, 523, 524, 526, 528, 530, 531, 533, 535, 538, 545, 548, 549, 555, 558, 559, 560, 562, 564, 565, 567, 568, 570, 573, 574, 575, 577, 578, 579, 583, 584, 585, 586, 587, 589, 590, 591, 592, 593, 594, 595, 597, 598, 603, 605, 609, 610, 611, 613, 614, 615, 616, 620, 621, 622, 624, 625, 628, 630, 632, 633, 634, 635, 636, 640, 641, 643, 644, 650, 651, 652, 653, 654, 656, 658, 659, 660, 661, 662, 664, 665, 671, 673, 674, 675, 676, 678, 680, 681, 683, 684, 687, 689, 694, 696, 697, 698, 699, 700, 701, 704, 705, 706, 707, 709, 710, 712, 716, 718, 721, 723, 725, 727, 730, 732, 733, 734, 735, 737, 738, 739, 740, 741, 742, 744, 745, 747, 750, 752, 754, 755, 756, 757, 758, 759, 760, 761, 762, 763, 764, 766, 767, 770, 771, 775, 776, 777, 778, 784, 785, 786, 787, 793, 795, 797, 800, 801, 806, 808, 810, 811, 814, 816, 822, 823, 827, 828, 829, 830, 831, 834, 836, 837, 838, 840, 841, 842, 843, 844, 846, 847, 848, 850, 851, 852, 853, 854, 857, 858, 860, 861, 862, 864, 866, 867, 869, 870, 871, 872, 873, 875, 877, 878, 887, 888, 889, 891, 892, 893, 894, 898, 902, 903, 905, 906, 909, 912, 913, 914, 915, 916, 918, 919, 920, 921, 922, 924, 925, 927, 929, 931, 936, 937, 938, 939, 941, 942, 943, 944, 946, 947, 949, 951, 953, 957, 960, 961, 962, 967, 969, 971, 973, 974, 982, 984, 987, 989, 990, 993, 995, 997, 998, 1000, 1002, 1003, 1004, 1007, 1009, 1011, 1015, 1016, 1022, 1023, 1024, 1029, 1032, 1033, 1035, 1039, 1041, 1042, 1044, 1045, 1048, 1052, 1053, 1055, 1056, 1059, 1062, 1064, 1065, 1066, 1070, 1073, 1079, 1083, 1084, 1085, 1086, 1088, 1090, 1091, 1092, 1093, 1095, 1099, 1101, 1102, 1104, 1105, 1106, 1107, 1108, 1110, 1113, 1116, 1117, 1118, 1120, 1121, 1122, 1125, 1126, 1132, 1133, 1134, 1135, 1140, 1142, 1144, 1145, 1146, 1147, 1148, 1149, 1150, 1152, 1154, 1155, 1158, 1160, 1164, 1169, 1172, 1174, 1179, 1180, 1182, 1183, 1185, 1186, 1187, 1188, 1189, 1191, 1193, 1194, 1196, 1199, 1200, 1201, 1202, 1204, 1207, 1209, 1211, 1213, 1215, 1221, 1225, 1226, 1227, 1231, 1232, 1233, 1234, 1235, 1236, 1240, 1244, 1245, 1246, 1247, 1248, 1249, 1254, 1255, 1261, 1262, 1263, 1265, 1268, 1270, 1271, 1273, 1274, 1277, 1280, 1281, 1283, 1287, 1288, 1289, 1290, 1291, 1292, 1293, 1296, 1297, 1299, 1302, 1304, 1306, 1309, 1310, 1313, 1314, 1315, 1316, 1319, 1321, 1323, 1324, 1327, 1328, 1333, 1334, 1335, 1337, 1338, 1339, 1340, 1341, 1342, 1344, 1345, 1346, 1349, 1352, 1353, 1357, 1361, 1364, 1366, 1369, 1370, 1374, 1375, 1376, 1377, 1381, 1383, 1386, 1388, 1389, 1391, 1392, 1393, 1395, 1396, 1397, 1400, 1401, 1406, 1407, 1408, 1411, 1412, 1413, 1415, 1416, 1417, 1418, 1419, 1422, 1423, 1426, 1432, 1434, 1437, 1438, 1439, 1441, 1444, 1445, 1446, 1449, 1452, 1454, 1455, 1456, 1457, 1460, 1461, 1463, 1467, 1469, 1470, 1473, 1474, 1475, 1478, 1480, 1482, 1484, 1485, 1488, 1489, 1490, 1491, 1492, 1493, 1497, 1498, 1503, 1504, 1505, 1507, 1508, 1511, 1512, 1513, 1518, 1519, 1520, 1521, 1524, 1525, 1526, 1528, 1529, 1530, 1532, 1533, 1536, 1538, 1545, 1548, 1552, 1553, 1554, 1558, 1559, 1563, 1564, 1572, 1575, 1577, 1579, 1580, 1584, 1585, 1587, 1588, 1592, 1594, 1596, 1597, 1599, 1600, 1601, 1602, 1607, 1608, 1609, 1610, 1611, 1613, 1614, 1615, 1616, 1618, 1621, 1624, 1628, 1629, 1633, 1635, 1638, 1642, 1644, 1645, 1646, 1647, 1648, 1650, 1651, 1654, 1658, 1659, 1662, 1664, 1667, 1669, 1671, 1674, 1677, 1678, 1681, 1682, 1683, 1684, 1687, 1690, 1692, 1695, 1696, 1698, 1701, 1702, 1704, 1705, 1707, 1711, 1712, 1714, 1715, 1718, 1721, 1723, 1725, 1726, 1728, 1729, 1730, 1732, 1734, 1737, 1743, 1744, 1746, 1748, 1749, 1750, 1752, 1753, 1755, 1756, 1758, 1760, 1761, 1765, 1768, 1769, 1770, 1771, 1772, 1774, 1775, 1776, 1778, 1781, 1782, 1784, 1785, 1787, 1795, 1796, 1798, 1800, 1805, 1806, 1807, 1808, 1810, 1812, 1813, 1815, 1817, 1818, 1819, 1820, 1823, 1824, 1825, 1830, 1832, 1834, 1835, 1836, 1837, 1840, 1842, 1843, 1845, 1846, 1847, 1848, 1849, 1853, 1854, 1856, 1859, 1861, 1862, 1865, 1867, 1869, 1870, 1872, 1873, 1876, 1877, 1879, 1880, 1883, 1885, 1889, 1895, 1897, 1899, 1901, 1904, 1905, 1906, 1909, 1911, 1914, 1915, 1918, 1919, 1921, 1922, 1926, 1930, 1931, 1933, 1936, 1937, 1938, 1939, 1940, 1941, 1943, 1946, 1948, 1950, 1954, 1955, 1956, 1959, 1960, 1965, 1967, 1970, 1972, 1973, 1974, 1977, 1978, 1979, 1981, 1982, 1984, 1986, 1987, 1989, 1991, 1993, 1994, 1999);

				//class name is not needed to call the static function within the class.
				List<Integer> result= notInSecondHash(la,lb);
			    if (result!=null && !result.isEmpty())
			    {
					System.out.println("the values in the 1st list that's not in the 2nd list");

					for (Integer e:result) {
						System.out.println(e);
					}
			    }	
			   else
			   {
					System.out.println("no values are found that's only in the 1st list.");
				}
		
				long endTime   = System.nanoTime();
				long totalTime = endTime - startTime;
				System.out.println(totalTime + "nanoTime");	    
			    
   }
	
	private static List<Integer> notInSecond(List<Integer> la, List<Integer> lb)
	{

		List<Integer> lc= new ArrayList<Integer>();
		
		if (la==null | lb==null){
			System.out.println("first or second list is null, please initialize them properly");
		}
		else{
				for (Integer e : la) {
					if (    ! ( lb.contains(e) )  ){
						lc.add(e);		
				    }
				}
		}
		return lc;
	}
	
	private static List<Integer> notInSecondHash (List<Integer> la, List<Integer> lb )
	{
		Set<Integer> s=new HashSet<Integer>(lb);
		List<Integer> lc=new ArrayList<Integer>();
		
		if (la==null | lb==null){
			System.out.println("first or second list is null, please initialize them properly");
		}
		else{
				for (Integer e : la) {
					if (    ! ( s.contains(e) )  ){
						lc.add(e);		
				    }
				}
		}
		
		return lc;
		
	}
	

}