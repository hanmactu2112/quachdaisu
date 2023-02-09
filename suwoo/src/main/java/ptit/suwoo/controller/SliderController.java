package ptit.suwoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ptit.suwoo.Repository.SliderRepository;
import ptit.suwoo.model.Image;
import ptit.suwoo.model.Slider;
import ptit.suwoo.service.SliderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;

@Controller
public class SliderController {
    private static final String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/slider";
    @Autowired
    SliderService sliderService;
    @Autowired
    SliderRepository sliderRepository;

    @GetMapping("/admin/manageSlider")
    public String manageSlider(Model model) {
        return manageSlider(1, model);
    }

    @GetMapping("/admin/manageSlider/{page}")
    public String manageSlider(@PathVariable int page, Model model) {
        if (page > 0) {
            Page<Slider> sliderPage = sliderService.findAll(page, 5);
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", sliderPage.getTotalPages());
            model.addAttribute("totalItems", sliderPage.getTotalElements());
            model.addAttribute("sliders", sliderPage);
            return "managerSlider";
        } else {
            model.addAttribute("error", "Không tìm thấy");
            model.addAttribute("currentPage", page);

            model.addAttribute("totalPages", 0);
            model.addAttribute("totalItems", 0);
            return "managerSlider";
        }
    }

    @GetMapping("/admin/addSlider")
    public String addSlider() {
        return "addSlider";
    }

    @PostMapping("/admin/addSlider")
    public String addSlider(@RequestParam("content") String content, @RequestParam("url") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (!file.isEmpty() && content.length() <= 20) {
            String imageUUID = file.getOriginalFilename();

            Random random = new Random();
            String ext = "";
            for (int j = imageUUID.length() - 1; j >= 0; j--) {
                if (imageUUID.charAt(j) == '.') {
                    ext = imageUUID.substring(j, imageUUID.length());
                }
            }
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            int t = 1;
            while (t == 1) {
                imageUUID = String.format("%s%s", System.currentTimeMillis(), random.nextInt(100000) + ext);
                fileNameAndPath = Paths.get(uploadDir, imageUUID);
                boolean exists = Files.exists(fileNameAndPath);
                if (!exists) t = 0;
            }
            try {
                Files.write(fileNameAndPath, file.getBytes());
                Slider slider = new Slider();
                slider.setContent(content);
                slider.setUrl(imageUUID);
                slider.setNgayTao(Timestamp.valueOf(LocalDateTime.now()));
                sliderRepository.save(slider);
                redirectAttributes.addFlashAttribute("success", "Thêm thành công!!");
                return "redirect:/admin/manageSlider";
            } catch (Exception e) {
                System.err.println("exception:" + e.getMessage());
                redirectAttributes.addFlashAttribute("error", "Không thành công!!");
                return "redirect:/admin/manageSlider";
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "Không thành công!!");
            return "redirect:/admin/addSlider";
        }
    }

    @GetMapping("/admin/deleteSlider/{id}")
    public String deleteSlide(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            if (sliderRepository.countSlider() > 4) {
                sliderService.deleteSlideById(id);
                redirectAttributes.addFlashAttribute("success", "Xóa thành công!!");
            } else
                redirectAttributes.addFlashAttribute("error", "Slider còn ít. Không thể xóa!!");
        } catch (SQLException e) {
            redirectAttributes.addFlashAttribute("error", "Xóa thất bại!!");
        }

        return "redirect:/admin/manageSlider";
    }

}
