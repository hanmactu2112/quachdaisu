package ptit.suwoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ptit.suwoo.Dto.AdminDTO;
import ptit.suwoo.Repository.NguoiDungRepository;
import ptit.suwoo.Repository.UserRoleRepository;
import ptit.suwoo.model.Admin;
import ptit.suwoo.model.NguoiDung;
import ptit.suwoo.model.UserRole;
import ptit.suwoo.service.AdminService;
import ptit.suwoo.service.RoleService;
import ptit.suwoo.service.UserRoleService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {
    public static String uploadDir = System.getProperty("user.dir") + "/adminImages";

    @Autowired
    AdminService adminService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    RoleService roleService;
    @Autowired
    private NguoiDungRepository nguoiDungRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @GetMapping("/managerStaff")
    public String managerStaff(Model model){
        List<Admin> admin = adminService.findAllAdmin();
        for (int i = 0; i < admin.size(); i++) {
            System.err.println(admin.get(i).getName());
            System.out.println(admin.get(i));
        }
        model.addAttribute("admins",admin);
        return "managerStaff";
    }
    @GetMapping("/deleteStaff/{id}")
    public String deleteStaff(@PathVariable Long id,RedirectAttributes redir){
        Optional<NguoiDung> nd = nguoiDungRepository.findById(id);
        if(!nd.isPresent()){
            redir.addFlashAttribute("error_delete","Khong the Tim Thay Nhan Vien de xoa!!");
            return "redirect:/managerStaff";
        }
        UserRole ur = userRoleRepository.findByidUser(nd.get()).get(0);

        userRoleService.deleteById(ur.getId());
        adminService.deleteAdminById(id);
        return "redirect:/managerStaff";
    }
    @GetMapping("/editStaff/{id}")
    public  String editStaff(@PathVariable Long id, Model model, RedirectAttributes redir){
        AdminDTO nd = new AdminDTO();
        Optional<Admin> a = adminService.findById(id);
        if(!a.isPresent()){
            redir.addFlashAttribute("error_update","Khong the Tim Thay Nhan Vien de sua!!");
            return "redirect:/managerStaff";
        }
        nd.setId(String.valueOf(a.get().getId()));
        nd.setName((a.get()).getName());
        nd.setGioiTinh((a.get()).isGioiTinh());
        nd.setEmail((a.get()).getEmail());
        nd.setMatKhau((a.get()).getMatKhau());
        nd.setSdt("0"+(a.get()).getSdt());
        nd.setNgaySinh((a.get()).getNgaySinh().toString());
        nd.setUrlImg((a.get()).getUrlImg());
        System.out.println((a.get()).getNgaySinh());
        System.err.println((a.get()).isGioiTinh());
        nd.setDiaChi((a.get()).getDiaChi());
        model.addAttribute("role","ROLE_ADMIN");
        model.addAttribute("title","Sửa thông tin nv: "+(a.get()).getName());
        model.addAttribute("nguoiDung", nd);
        return "add_staff";
    }
}
