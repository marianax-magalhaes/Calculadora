package br.com.calculadora.controller;

import br.com.calculadora.domain.Operacao;
import br.com.calculadora.services.CalculadoraService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/calculadora")
public class CalculadoraController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double operandoA=0;
        double operandoB=0;
        int operador=0;
        try {
            operandoA = Double.valueOf(req.getParameter("operandoA"));
            operandoB = Double.valueOf(req.getParameter("operandoB"));
            operador = Integer.valueOf(req.getParameter("operador"));
        } catch (NumberFormatException e){
            resp.getWriter().println("Input inválido");
        }
        double resultado = 0;

        CalculadoraService calculadoraService = new CalculadoraService();

        Operacao operacao = null;

        switch (operador) {
            case 0: {operacao = Operacao.SOMA;break;}
            case 1: {operacao = Operacao.SUBTRACAO; break;}
            case 2: {operacao = Operacao.MULTIPLICACAO; break;}
            case 3: {operacao = Operacao.DIVISAO; break;}
            default:{resp.getWriter().println("Operação inválida");};
        }

        resultado = calculadoraService.calcular(operandoA, operandoB, operacao);
        resp.getWriter().println(resultado);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Servlet no ar");
    }
}
