<%-- 
    Document   : header
    Created on : 30/03/2016, 20:39:41
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<header>
    <div class="pre-header">
        <div class="btn-pre-header">
            <button class="btn btn-default btn-sm" onclick="abrirModalLogin()">Login</button>
            <div class="modal-pequeno-login" onmousewheel="fecharModaisPequenos()">
                <div id="login">
                    <form action="login" method="POST" class="form-group">
                        <div class="form-group-sm">
                            <input type="email" placeholder="Email" class="form-control"/>
                        </div>
                        <div class="form-group-sm">
                            <input type="password" placeholder="Senha" class="form-control"/><br>
                        </div>
                        <input type="submit" class="btn btn-primary btn-sm" value="Logar"/>
                    </form>
                </div>
            </div>
        </div>
        <div class="btn-pre-header">
            <button class="btn btn-default btn-sm" onclick="abrirModalParticipe()">Participe</button>
            <div class="modal-pequeno-participe" onmousedown="fecharModaisPequenos()">
                <div id="participe">
                    <form action="participar" method="post" class="form-group">
                        <div class="form-group-sm">
                            <input type="email" placeholder="Email" class="form-control"/>
                        </div>
                        <div class="form-group-sm">
                            <select class="form-control">
                                <option value="ADMIN">ALUNO</option>
                                <option value="PROFESSOR">PROFESSOR</option>
                            </select>
                        </div><br>
                        <input type="submit" class="btn btn-primary btn-sm" value="Participar"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="header">
        <img src="/assets/icons/Dood.png">
    </div>
</header>