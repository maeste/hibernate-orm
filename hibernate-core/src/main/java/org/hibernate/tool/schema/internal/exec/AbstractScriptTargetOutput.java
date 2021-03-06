/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.tool.schema.internal.exec;

import java.io.IOException;
import java.io.Writer;

import org.hibernate.internal.util.StringHelper;
import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.hibernate.tool.schema.spi.ScriptTargetOutput;

/**
 * @author Steve Ebersole
 */
public abstract class AbstractScriptTargetOutput implements ScriptTargetOutput {
	protected static final String NEWLINE;
	static {
		final String systemNewLine = System.getProperty( "line.separator" );
		NEWLINE = StringHelper.isNotEmpty( systemNewLine ) ? systemNewLine : "\n";
	}

	protected abstract Writer writer();

	@Override
	public void prepare() {
	}

	@Override
	public void accept(String command) {
		try {
			writer().write( command );
			writer().write( NEWLINE );
			writer().flush();
		}
		catch (IOException e) {
			throw new CommandAcceptanceException( "Could not write to target script file", e );
		}
	}

	@Override
	public void release() {
	}
}
