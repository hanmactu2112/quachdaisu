$(document).ready(function () {
    $('.menu-toggle').click(function (e) { 
        e.preventDefault();
        $('.navbar-menu').addClass('active');
        $('.cover').addClass('active');
    });
    $('.cover').click(function (e) { 
        e.preventDefault();
        $('.cover').removeClass('active');
        $('.navbar-menu').removeClass('active');
    });
    $('.slider-blog').slick({
        dots: true,
        arrows: false,
        infinite: true,
        slidesToShow: 3,
        slidesToScroll:2,
        responsive: [{
  
          breakpoint: 1024,
          settings: {
            slidesToShow: 3,
            infinite: true
          }
    
        }, 
        {
    
          breakpoint: 800,
          settings: {
            slidesToShow: 2,
            dots: true
          }
    
        },
        {
          breakpoint: 480,
          settings: {
            slidesToShow: 1,
            dots: true
          }
        },
         {
    
          breakpoint: 300,
          settings: "unslick" // destroys slick
    
        }]
      });
});