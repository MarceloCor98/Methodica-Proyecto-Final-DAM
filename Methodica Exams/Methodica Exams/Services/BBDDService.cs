using Methodica_Exams.Model;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Methodica_Exams.Services
{
    public static class BBDDService
    {
        private static readonly methodicadbEntities contexto;
        static BBDDService()
        {
            contexto = new methodicadbEntities();
            contexto.usuarios.Load();
            contexto.alumnos.Load();
            contexto.cursos.Load();
            contexto.profesores.Load();
            contexto.examenes.Load();
            contexto.preguntas.Load();
            contexto.respuestas.Load();
            contexto.notas.Load();

        }

        public static void CargarBD()
        {
        }


        // USUARIOS
        public static ObservableCollection<usuarios> getUsuarios()
        {
            return contexto.usuarios.Local;
        }

        public static usuarios getUsuario(string username)
        {
            var usuario = (from u in contexto.usuarios
                           where u.username == username
                           select u);
            return usuario.First();
        }

        public static bool usuarioExiste(string username)
        {
            var usuario = (from u in contexto.usuarios
                           where u.username == username
                           select u);
            return usuario.Count() > 0;
        }

        // PROFESORES
        public static profesores getProfesorByUsername(string username)
        {
            var profesor = (from p in contexto.profesores
                           where p.username == username
                           select p).First();
            return profesor;
        }

        // ALUMNOS

        public static alumnos getAlumnoByUsername(string username)
        {
            var alumno = (from a in contexto.alumnos
                          where a.username == username
                            select a).First();
            return alumno;
        }

        public static alumnos getAlumnoById(long idAlumno)
        {
            var alumno = (from a in contexto.alumnos
                          where a.id == idAlumno
                          select a).First();
            return alumno;
        }

        // CURSOS

        public static ObservableCollection<cursos> getCursos()
        {
            return contexto.cursos.Local;
        }
        public static cursos getCurso(string nombre)
        {
            var curso = (from c in contexto.cursos
                           where c.nombre == nombre
                         select c).First();
            return curso;
        }

        public static ObservableCollection<cursos> getCursosByProfesor(long idProfesor)
        {
            var curso = (from c in contexto.cursos
                         where c.id_profesor == idProfesor 
                         select c);
            return new ObservableCollection<cursos>(curso);
        }

        // EXAMENES

        public static ObservableCollection<examenes> getExamenesActivos(long idCurso)
        {
            var examenes = (from e in contexto.examenes
                            where e.activo && e.id_curso == idCurso
                            select e);
            return new ObservableCollection<examenes>(examenes);
        }

        public static void AddExamen(examenes examen)
        {
            contexto.examenes.Add(examen);
            Guardar();
        }

        public static void DeleteExamen(examenes examen)
        {
            var preguntas = (from p in contexto.preguntas
                         where p.id_examen == examen.id
                         select p);

            contexto.preguntas.RemoveRange(preguntas);
            contexto.examenes.Remove(examen);
            contexto.SaveChanges();
        }

        public static void DeleteExamenById(long idExamen)
        {
            var preguntas = (from p in contexto.preguntas
                             where p.id_examen == idExamen
                             select p);

            contexto.preguntas.RemoveRange(preguntas);

            contexto.examenes.Remove(getExamenById(idExamen));
            Guardar();
        }

        public static examenes getExamenById(long id)
        {
            var examen = (from e in contexto.examenes
                         where e.id == id
                         select e).First();
            return examen;
        }

        public static bool isExamenYaRealizadoPorAlumno(alumnos alumno,long idExamen)
        {
            var respuestas = (from r in contexto.respuestas
                              where r.id_alumno == alumno.id && r.preguntas.id_examen == idExamen
                              select r);
            return respuestas.Count() > 0 ;
        }

        public static ObservableCollection<examenes> getExamenesCorregidosByCurso(long idCurso)
        {
            var examenes = (from e in contexto.examenes
                          where e.id_curso == idCurso && e.corregido
                          select e);
            return new ObservableCollection<examenes>(examenes);
        }

        // NOTAS

        public static void AddNota(notas nota)
        {
            contexto.notas.Add(nota);
            Guardar();
        }

        public static ObservableCollection<notas> getNotasByCursoAlumno(long idCurso,long idAlumno)
        {
            var notas = (from n in contexto.notas
                        where n.examenes.id_curso == idCurso && n.alumnos.id == idAlumno
                         select n);
            return new ObservableCollection<notas>(notas);
        }

        public static ObservableCollection<notas> getNotasByTema(long idTema)
        {
            var notas = (from n in contexto.notas
                         where n.examenes.id_tema == idTema && n.examenes.corregido
                         select n);
            return new ObservableCollection<notas>(notas);
        }

        public static notas GetNotaByExamenAlumno(examenes e, alumnos a)
        {
            var nota = (from n in contexto.notas
                         where n.id_examen == e.id && n.id_alumno == a.id
                         select n);
            if (nota.Count() > 0)
                return nota.First();
            else
                return null;

        }

        public static ObservableCollection<notas> getNotas()
        {
            return contexto.notas.Local;
        }

        // TEMAS 

        public static temas getTemaById(long id)
        {
            var tema = (from t in contexto.temas
                          where t.id == id
                          select t).First();
            return tema;
        }

        // PREGUNTAS

        public static void AddPregunta(preguntas pregunta)
        {
            contexto.preguntas.Add(pregunta);
            Guardar();
        }

        public static void DeletePregunta(preguntas pregunta)
        {
            contexto.preguntas.Remove(pregunta);
            Guardar();
        }
        public static preguntas getPreguntaById(long idPregunta)
        {
            var pregunta = (from p in contexto.preguntas
                        where p.id == idPregunta
                            select p).First();
            return pregunta;
        }

        public static ObservableCollection<respuestas> getRespuestasByExamenAndAlumno(long idExamen, long idAlumno)
        {
            var respuestas = (
                from r in contexto.respuestas
                where r.preguntas.id_examen == idExamen && r.id_alumno == idAlumno
                select r);

            return new ObservableCollection<respuestas>(respuestas);
        }

        public static void Guardar()
        {
            contexto.SaveChanges();
        }
    }
}
