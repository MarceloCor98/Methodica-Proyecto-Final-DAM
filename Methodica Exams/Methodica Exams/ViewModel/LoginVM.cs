using Methodica_Exams.Model;
using Methodica_Exams.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Methodica_Exams.ViewModel
{
    public class LoginVM
    {
        public usuarios usuarioLogueado;
        public LoginVM(usuarios usuarioLogueado)
        {
            this.usuarioLogueado = usuarioLogueado;
        }



        public bool AutenticarUsuario(string username, string password)
        {
            bool autenticado;

            if (!(username == ""))
            {
                usuarioLogueado = BBDDService.getUsuario(username);
                autenticado = !(usuarioLogueado == null);

                if (autenticado)
                    autenticado = BCrypt.Net.BCrypt.Verify(password, usuarioLogueado.password);

            }
            else
                autenticado = false;



            return autenticado;
        }


    }
}
