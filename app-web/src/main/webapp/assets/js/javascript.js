/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function (){
    $('#login').hide();
    $('#participe').hide();
});

function abrirModalLogin(){
    fecharModaisPequenos();
    $('#login').fadeIn(200);
    $('.modal-pequeno-login').css({
        display: "block"
    });
}

function abrirModalParticipe(){
    fecharModaisPequenos();
    $('#participe').fadeIn(200);
    $('.modal-pequeno-participe').css({
        display: "block"
    });
}

function fecharModaisPequenos(){
    $('#login').hide();
    $('#participe').hide();
    $('.modal-pequeno-login').css({
        display: "none"
    });
    $('.modal-pequeno-participe').css({
        display: "none"
    });
}