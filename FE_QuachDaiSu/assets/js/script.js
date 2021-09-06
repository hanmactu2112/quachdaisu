$(document).ready(function() {
    $('.client-carousel').owlCarousel({
        center: true,
        autoplay: true,
        dots: true,
        loop: true,
        responsive: {
            0:{
                items:1
            }
        }
    })
});

$(document).ready(function() {
    $("#menu-icon").click(function(){
        $(".navbar__link").slideToggle("slow");
      });
});
$(document).ready(function() {
    var $btns=$('.btn').click(function() {
        if (this.id == 'all') {
            $('#list-product > div').fadeIn(450);
          } else {
            
            var $el = $('.' + this.id).fadeIn(450);
            $('#list-product > div').not($el).hide();
          }
          $btns.removeClass('active');
          $(this).addClass('active');
        
    });
    
});

$(document).ready(function() {
    $('.list-icon li').hover(function(){
        $(this).css("background-color", "#dd2f31");
        }, function(){
        $(this).css("background-color", "white");
      });
});


