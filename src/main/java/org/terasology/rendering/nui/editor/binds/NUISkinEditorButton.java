/*
 * Copyright 2015 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.rendering.nui.editor.binds;

import org.terasology.input.BindButtonEvent;
import org.terasology.input.DefaultBinding;
import org.terasology.input.InputType;
import org.terasology.input.Keyboard;
import org.terasology.input.RegisterBindButton;

/**
 * Button that opens the NUI skin editor, or closes it if it's active.
 */
@RegisterBindButton(id = "nuiSkinEditor", description = "${engine:menu#binding-org.terasology.rendering.nui-skin-editor}", category = "src/main/java/org/terasology/rendering/nui")
@DefaultBinding(type = InputType.KEY, id = Keyboard.KeyId.F11)
public class NUISkinEditorButton extends BindButtonEvent {
}
