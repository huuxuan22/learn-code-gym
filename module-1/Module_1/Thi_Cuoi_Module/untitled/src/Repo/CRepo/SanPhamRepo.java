package Repo.CRepo;

import Model.SanPham;
import Model.SanPhamNK;
import Model.SanPhamXK;
import Repo.IRepo.ISanPham;
import Util.WriteAndReadFile;

import java.util.ArrayList;

import static Util.WriteAndReadFile.readFileToCSV;

public class SanPhamRepo implements ISanPham<SanPham> {
    private static  final String Path_File_SanPhamXK = "D:\\Module_2\\Thi_Cuoi_Module\\untitled\\src\\File\\SanPhamXK.CSV";
    private static final String Path_File_SanPhamNK = "D:\\Module_2\\Thi_Cuoi_Module\\untitled\\src\\File\\SanPhamNK.CSV";

    @Override
    public ArrayList<SanPhamNK> getAllNK() {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<SanPhamNK> sanPhamsList = new ArrayList<>();
        stringList = readFileToCSV(Path_File_SanPhamNK);
        String [] array = null;
        for (String line : stringList){
            array = line.split(",");
            try {
                SanPhamNK khachNuocNgoai = new SanPhamNK(array[0], array[1], array[2],Integer.parseInt(array[3]),Integer.parseInt(array[4]),array[5],Integer.parseInt(array[6]),array[7],Integer.parseInt(array[8]));
                sanPhamsList.add(khachNuocNgoai);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return sanPhamsList;
    }

    @Override
    public ArrayList<SanPhamXK> getAllXK() {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<SanPhamXK> sanPhamXKS = new ArrayList<>();
        stringList = readFileToCSV(Path_File_SanPhamXK);
        String [] array = null;
        for (String line : stringList){
            array = line.split(",");
            try {
                SanPhamXK sanPhamXK = new SanPhamXK(array[0], array[1], array[2],Integer.parseInt(array[3]),Integer.parseInt(array[4]),array[5],Integer.parseInt(array[6]),array[7]);
                sanPhamXKS.add(sanPhamXK);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return sanPhamXKS;
    }

    @Override
    public void addSanPham(SanPham sanPham) {
        if (sanPham instanceof SanPhamXK){
            ArrayList<String> stringList = new ArrayList<>();
            stringList.add(((SanPhamXK)sanPham).getInforToCSV());
            WriteAndReadFile.writeFileToCSV(Path_File_SanPhamXK,stringList,true);
        }else {
            ArrayList<String> stringList = new ArrayList<>();
            stringList.add(((SanPhamNK)sanPham).getInforToCSV());
            WriteAndReadFile.writeFileToCSV(Path_File_SanPhamNK,stringList,true);
        }
    }
}
