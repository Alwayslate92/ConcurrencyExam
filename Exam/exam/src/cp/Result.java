/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cp;


import java.nio.file.Path;

/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public interface Result
{
	/**
	 * The file ({@link Path}) of this result
	 * @return file ({@link Path}) of this result
	 */
	public Path path();
	
	public int number();
}
