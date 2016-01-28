// jQuery(document).ready(function($){
//     $("#join").on('click',function(e){
//         e.preventDefault();
//         location.href = $(this).attr('href') + '?a=rejoindre&room='  + $('#room-name').val() ;
//     });
//     $("#new").on('click',function(e){
//         e.preventDefault();
//         location.href = $(this).attr('href') + '?a=creationRoom&room='  + $('#room-name').val() ;
//     });
// })


jQuery(document).ready(function($){
    
    $("#join").on('click',function(e){
        e.preventDefault();
        location.href = $(this).attr('href') + '?a=rejoindre&room='  + $('#room-name').val() + "?user_email="+$('#email-name').val() ;
    });
    
    $("#new").on('click',function(e){
        e.preventDefault();
        location.href = $(this).attr('href') + '?a=creationRoom&room='  + $('#room-name').val() ;
    });
})

